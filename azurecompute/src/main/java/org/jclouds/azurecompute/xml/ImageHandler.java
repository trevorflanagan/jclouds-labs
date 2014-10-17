/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.azurecompute.xml;

import static com.google.common.base.Strings.emptyToNull;
import static org.jclouds.util.SaxUtils.currentOrNull;

import java.net.URI;
import java.util.List;

import org.jclouds.azurecompute.domain.Image;
import org.jclouds.azurecompute.domain.OSType;
import org.jclouds.http.functions.ParseSax;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * @see <a href="http://msdn.microsoft.com/en-us/library/jj157191" >api</a>
 */
final class ImageHandler extends ParseSax.HandlerForGeneratedRequestWithResult<Image> {
   private String name;
   private String location;
   private String affinityGroup;
   private String label;
   private String category;
   private String description;
   private OSType os;
   private URI mediaLink;
   private Integer logicalSizeInGB;
   private final List<String> eula = Lists.newArrayList();

   private final StringBuilder currentText = new StringBuilder();

   @Override public Image getResult() {
      Image result = Image.create(name, location, affinityGroup, label, description, category, os, mediaLink,
            logicalSizeInGB, ImmutableList.copyOf(eula));
      resetState(); // handler is called in a loop.
      return result;
   }

   private void resetState() {
      name = location = affinityGroup = label = description = category = null;
      os = null;
      mediaLink = null;
      logicalSizeInGB = null;
      eula.clear();
   }

   @Override public void endElement(String ignoredUri, String ignoredName, String qName) {
      if (qName.equals("OS")) {
         os = OSType.fromValue(currentOrNull(currentText));
      } else if (qName.equals("Name")) {
         name = currentOrNull(currentText);
      } else if (qName.equals("LogicalSizeInGB")) {
         String gb = currentOrNull(currentText);
         if (gb != null) {
            logicalSizeInGB = Integer.parseInt(gb);
         }
      } else if (qName.equals("Description")) {
         description = currentOrNull(currentText);
      } else if (qName.equals("Category")) {
         category = currentOrNull(currentText);
      } else if (qName.equals("Location")) {
         location = currentOrNull(currentText);
      } else if (qName.equals("AffinityGroup")) {
         affinityGroup = currentOrNull(currentText);
      } else if (qName.equals("MediaLink")) {
         String link = currentOrNull(currentText);
         if (link != null) {
            mediaLink = URI.create(link);
         }
      } else if (qName.equals("Eula")) {
         String eulaField = currentOrNull(currentText);
         if (eulaField != null) {
            for (String eula : Splitter.on(';').split(eulaField)) {
               if ((eula = emptyToNull(eula.trim())) != null) { // Dirty data in RightScale eula field.
                  this.eula.add(eula);
               }
            }
         }
      } else if (qName.equals("Label")) {
         label = currentOrNull(currentText);
      }
      currentText.setLength(0);
   }

   @Override public void characters(char ch[], int start, int length) {
      currentText.append(ch, start, length);
   }
}

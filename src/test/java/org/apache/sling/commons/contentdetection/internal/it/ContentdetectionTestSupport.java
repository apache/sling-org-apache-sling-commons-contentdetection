/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.commons.contentdetection.internal.it;

import java.io.File;

import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;

import static org.ops4j.pax.exam.CoreOptions.bundle;
import static org.ops4j.pax.exam.CoreOptions.junitBundles;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;

public abstract class ContentdetectionTestSupport {

    @Configuration
    public Option[] configuration() {
        return options(
                // update pax logging for SLF4J 2
                mavenBundle()
                        .groupId("org.ops4j.pax.logging")
                        .artifactId("pax-logging-api")
                        .version("2.3.0"),
                mavenBundle("org.apache.sling", "org.apache.sling.commons.mime").versionAsInProject(),
                mavenBundle("commons-io", "commons-io").versionAsInProject(),
                // SCR
                mavenBundle()
                        .groupId("org.osgi")
                        .artifactId("org.osgi.util.function")
                        .version("1.2.0"),
                mavenBundle()
                        .groupId("org.osgi")
                        .artifactId("org.osgi.util.promise")
                        .version("1.3.0"),
                mavenBundle()
                        .groupId("org.osgi")
                        .artifactId("org.osgi.service.component")
                        .version("1.5.1"),
                mavenBundle()
                        .groupId("org.apache.felix")
                        .artifactId("org.apache.felix.metatype")
                        .version("1.2.4"),
                mavenBundle()
                        .groupId("org.apache.felix")
                        .artifactId("org.apache.felix.scr")
                        .version("2.3.0"),

                // Tika 4.x
                mavenBundle("org.apache.commons", "commons-secure-xml", "1.1.0"),
                mavenBundle("org.commonmark", "commonmark", "0.32.0"),
                mavenBundle("org.commonmark", "commonmark-ext-gfm-strikethrough", "0.32.0"),
                mavenBundle("org.commonmark", "commonmark-ext-gfm-tables", "0.32.0"),
                mavenBundle("com.adobe.xmp", "xmpcore", "6.1.11"),
                mavenBundle("com.googlecode.plist", "dd-plist", "1.30"),
                mavenBundle("com.fasterxml.jackson.core", "jackson-core", "2.22.4"),
                mavenBundle("commons-codec", "commons-codec", "1.23.0"),
                mavenBundle("commons-logging", "commons-logging", "1.4.0"),
                mavenBundle("org.apache.commons", "commons-collections4", "4.6.0"),
                mavenBundle("org.apache.commons", "commons-compress", "1.28.0"),
                mavenBundle("org.apache.commons", "commons-csv", "1.14.1"),
                mavenBundle("org.apache.commons", "commons-exec", "1.6.0"),
                mavenBundle("org.apache.commons", "commons-lang3", "3.21.0"),
                mavenBundle("org.apache.commons", "commons-math3", "3.6.1"),
                mavenBundle("org.apache.logging.log4j", "log4j-api", "2.26.1"),
                mavenBundle("org.apache.pdfbox", "fontbox", "3.0.8"),
                mavenBundle("org.apache.pdfbox", "pdfbox", "3.0.8"),
                mavenBundle("org.apache.pdfbox", "pdfbox-io", "3.0.8"),
                mavenBundle("org.bouncycastle", "bcprov-jdk18on", "1.86"),
                mavenBundle("org.bouncycastle", "bcutil-jdk18on", "1.86"),
                mavenBundle("org.bouncycastle", "bcpkix-jdk18on", "1.86"),
                mavenBundle("org.jsoup", "jsoup", "1.24.1"),
                mavenBundle("org.ow2.asm", "asm", "9.11.1"),
                mavenBundle("org.tukaani", "xz", "1.12"),
                mavenBundle("org.apache.tika", "tika-core").versionAsInProject(),
                mavenBundle("org.apache.tika", "tika-bundle-standard").versionAsInProject(),
                // Sling Content Detection
                bundle(new File(System.getProperty("bundle.filename")).toURI().toString()),
                // testing
                junitBundles());
    }
}

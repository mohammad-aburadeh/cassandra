/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.cassandra.index.sasi.analyzer.filter;

import java.util.Locale;

import static org.apache.cassandra.utils.LocalizeString.toLowerCaseLocalized;
import static org.apache.cassandra.utils.LocalizeString.toUpperCaseLocalized;

/**
 * Basic/General Token Filters
 */
public class BasicResultFilters
{
    private static final Locale DEFAULT_LOCALE = Locale.getDefault();

    public static class LowerCase extends FilterPipelineTask<String, String>
    {
        private Locale locale;

        public LowerCase(Locale locale)
        {
            this.locale = locale;
        }

        public LowerCase()
        {
            this.locale = DEFAULT_LOCALE;
        }

        public String process(String input) throws Exception
        {
            return toLowerCaseLocalized(input, locale);
        }
    }

    public static class UpperCase extends FilterPipelineTask<String, String>
    {
        private Locale locale;

        public UpperCase(Locale locale)
        {
            this.locale = locale;
        }

        public UpperCase()
        {
            this.locale = DEFAULT_LOCALE;
        }

        public String process(String input) throws Exception
        {
            return toUpperCaseLocalized(input, locale);
        }
    }

    public static class NoOperation extends FilterPipelineTask<Object, Object>
    {
        public Object process(Object input) throws Exception
        {
            return input;
        }
    }
}

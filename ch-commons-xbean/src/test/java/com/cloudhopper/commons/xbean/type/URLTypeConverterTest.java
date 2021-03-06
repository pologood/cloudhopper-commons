package com.cloudhopper.commons.xbean.type;

/*
 * #%L
 * ch-commons-xbean
 * %%
 * Copyright (C) 2012 Cloudhopper by Twitter
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.cloudhopper.commons.xbean.ConversionException;
import com.cloudhopper.commons.xbean.TypeConverter;
import org.apache.log4j.Logger;
import org.junit.Test;

public class URLTypeConverterTest {
    private static final Logger logger = Logger.getLogger(URLTypeConverterTest.class);

    private TypeConverter pc = new URLTypeConverter();
    
    @Test
    public void validConversions() throws Exception {
        pc.convert("http://www.google.com");
        pc.convert("http://www.google.com/yo");
        pc.convert("http://www.google.com:81/yo?id=1");
    }
    
    @Test(expected=ConversionException.class)
    public void invalidURLThrowsException() throws Exception {
        pc.convert("www.google.com:81/yo?id=1");
    }
}

/*******************************************************************************
 * * Copyright 2012 Impetus Infotech.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 ******************************************************************************/
package com.impetus.kundera.property.accessor;

import java.nio.ByteBuffer;

import com.impetus.kundera.property.PropertyAccessException;
import com.impetus.kundera.property.PropertyAccessor;

/**
 * @author Amresh Singh
 *
 */
public class ByteAccessor implements PropertyAccessor<Byte>
{


    @Override
    public Byte fromBytes(byte[] b) throws PropertyAccessException
    {        
        try
        {
            //return new Byte(new String(b, Constants.ENCODING));
            return (ByteBuffer.wrap(b).get());
        }
        catch (NumberFormatException e)
        {            
            e.printStackTrace();
            return null;
        }       
    }


    @Override
    public byte[] toBytes(Object object) throws PropertyAccessException
    {
        Byte b = (Byte) object;
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.put(b);
        return buffer.array();        
    }


    @Override
    public String toString(Object object)
    {
        return object.toString();
    }

    
}
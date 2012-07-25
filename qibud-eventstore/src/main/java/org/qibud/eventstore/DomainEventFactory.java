/*
 * Copyright (c) 2012, Paul Merlin. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.qibud.eventstore;

import java.util.Map;
import org.codeartisans.java.toolbox.exceptions.NullArgumentException;
import org.json.JSONException;
import org.json.JSONObject;
import org.qibud.eventstore.DomainEventAttachment.DataProvider;

/**
 * Factory for DomainEvent.
 */
public class DomainEventFactory
{

    private final DomainEventIdentityGenerator localIdGen = new DomainEventIdentityGenerator();

    /**
     * Create a new DomainEvent.
     */
    public final DomainEvent newDomainEvent( String name, String data )
    {
        try {
            return newDomainEvent( name, new JSONObject( data ) );
        } catch ( JSONException ex ) {
            throw new IllegalArgumentException( "Event data is not valid JSON", ex );
        }
    }

    /**
     * Create a new DomainEvent.
     */
    public final DomainEvent newDomainEvent( String name, Map<String, String> data )
    {
        return newDomainEvent( name, new JSONObject( data ) );
    }

    /**
     * Create a new DomainEvent.
     */
    public final DomainEvent newDomainEvent( String name, JSONObject data )
    {
        NullArgumentException.ensureNotEmpty( "name", name );
        NullArgumentException.ensureNotNull( "data", data );
        return new DomainEventImpl( localIdGen.newIdentity(), name, data );
    }

    /**
     * Create a new DomainEventAttachment.
     */
    public final DomainEventAttachment newDomainEventAttachment( DataProvider dataProvider )
    {
        NullArgumentException.ensureNotNull( "data provider", dataProvider );
        return new DomainEventAttachment( localIdGen.newIdentity(), dataProvider );
    }

}

/*
 * Copyright 2003-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package groovy.bugs


class Groovy4980Bug extends GroovyTestCase {
    void testStaticOverloadedMixinMethods() {
        assertScript """
            class Outer4980 {
                class Inner4980 {
                    String firstName
                    String lastName
                }
            
                def doit() {
                    new Inner4980(firstName: "fred", lastName: "johnson")
                }
            }
            
            def inner = new Outer4980().doit()
            
            assert inner.firstName == 'fred'
            assert inner.lastName == 'johnson'
        """
    }
}


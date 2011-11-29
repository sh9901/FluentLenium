/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package fr.javafreelance.integration;


import fr.javafreelance.integration.localTest.LocalFluentCase;
import org.junit.Test;

import static fr.javafreelance.fluentlenium.core.filter.FilterConstructor.with;
import static org.fest.assertions.Assertions.assertThat;

public class JavascriptTest extends LocalFluentCase {

    @Test
    public void checkTextParam() {
        goTo(DEFAULT_URL + "javascript.html");
        assertThat(find("span",with("id").equalTo("default")).first().getText()).isEqualTo("unchanged");

        assertThat(find("#default").first().getText()).isEqualTo("unchanged");
        executeScript("change();");
        assertThat(find("#default").first().getText()).isEqualTo("changed");

    }

}
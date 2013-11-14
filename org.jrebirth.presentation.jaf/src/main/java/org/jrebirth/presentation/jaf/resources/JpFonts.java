/**
 * Get more info at : www.jrebirth.org .
 * Copyright JRebirth.org © 2011-2013
 * Contact : sebastien.bordes@jrebirth.org
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
package org.jrebirth.presentation.jaf.resources;

import static org.jrebirth.core.resource.Resources.create;

import org.jrebirth.core.resource.font.FontItem;
import org.jrebirth.core.resource.font.RealFont;

/**
 * The JpFonts interface providing all fonts.
 */
public interface JpFonts {

    /** The splash font. */
    FontItem PAGE = create(new RealFont(JpFontNames.DINk, 24));

    /** The typewriter font. */
    FontItem TYPEWRITER = create(new RealFont(JpFontNames.MIZIKE, 72));

    /** The slide title font. */
    FontItem SLIDE_TITLE = create(new RealFont(JpFontNames.Harabara, 45));

    /** The slide item. */
    FontItem SLIDE_ITEM = create(new RealFont(JpFontNames.Neuton_Cursive, 10));

    /** The dog splash. */
    FontItem DOG_SPLASH = create(new RealFont(JpFontNames.whiterabbit, 20));

    /** The wazaa splash. */
    FontItem WAZAA_SPLASH = create(new RealFont(JpFontNames.Turtles, 20));

    /** The prez title. */
    FontItem PREZ_TITLE = create(new RealFont(JpFontNames.Harabara, 26));

}

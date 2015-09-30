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
package org.jrebirth.af.presentation.jaf.resources;

import static org.jrebirth.af.core.resource.Resources.create;

import org.jrebirth.af.api.resource.font.FontExtension;
import org.jrebirth.af.api.resource.font.FontItem;
import org.jrebirth.af.core.resource.font.RealFont;
import org.jrebirth.af.presentation.resources.PrezFontNames;

/**
 * The JpFonts interface providing all fonts.
 */
public interface JpFonts {

    // /** The JRebirth title font. */
    // FontItem JR = create(new RealFont(JpFontNames.Gin_Rai, 36, FontExtension.OTF));

    /** The JRebirth title font. */
    FontItem JR = create(new RealFont(JpFontNames.Gin_Rai, 36, FontExtension.TTF));

    /** The page number font. */
    FontItem PAGE = create(new RealFont(PrezFontNames.BorisBlackBloxx, 36, FontExtension.TTF));

    /** The splash font. */
    FontItem SPLASH = create(new RealFont(JpFontNames.bewildet, 32, FontExtension.TTF));

    /** The typewriter font. */
    FontItem TYPEWRITER = create(new RealFont(JpFontNames.MIZIKE, 72, FontExtension.TTF));

    /** The dog splash. */
    FontItem DOG_SPLASH = create(new RealFont(JpFontNames.whiterabbit, 20, FontExtension.TTF));

    /** The slide title font. */
    FontItem SLIDE_TITLE = create(new RealFont(JpFontNames.Harabara, 45, FontExtension.TTF));

    /** The slide item. */
    FontItem SLIDE_ITEM = create(new RealFont(JpFontNames.Neuton_Cursive, 10, FontExtension.TTF));

    /** The prez title. */
    FontItem PREZ_TITLE = create(new RealFont(JpFontNames.Harabara, 88, FontExtension.TTF));

}

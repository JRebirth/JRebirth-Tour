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

import org.jrebirth.af.core.resource.color.ColorEnum;

/**
 * The JpColors interface providing all colors.
 */
public enum JpColors implements ColorEnum {

    // @formatter:off
    
    /** The slide title color. */
    SLIDE_TITLE {{ web("0088D3", 1.0) ; }},

    /** The slide title color. */
    PREZ_TITLE {{ web("F79508", 0.7); }},
    
    /** The soft blue color. */
    SOFT_BLUE {{ web("0499C4", 1.0); }},
    
    /** The soft black color. */
    SOFT_BLACK {{ web("000000", 1.0); }},
    
    /** The soft black color. */
    SOFT_WHITE {{ web("C0BDC1", 0.8); }}
    

}

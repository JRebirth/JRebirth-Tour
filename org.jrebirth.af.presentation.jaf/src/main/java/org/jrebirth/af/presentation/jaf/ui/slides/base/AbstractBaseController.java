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
package org.jrebirth.af.presentation.jaf.ui.slides.base;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.ui.base.AbstractSlideController;

// TODO: Auto-generated Javadoc
/**
 * The class <strong>AbstractTemplateController</strong>.
 * 
 * @param <M> the generic type
 * @param <V> the value type
 * @author Sébastien Bordes
 */
public abstract class AbstractBaseController<M extends AbstractBaseModel<M, V, ?>, V extends AbstractBaseView<M, ?, ? extends AbstractBaseController<M, V>>>
        extends AbstractSlideController<M, V> {

    /**
     * Default Constructor.
     * 
     * @param view the view to control
     * 
     * @throws CoreException if an error occurred while creating event handlers
     */
    public AbstractBaseController(final V view) throws CoreException {
        super(view);
    }

}

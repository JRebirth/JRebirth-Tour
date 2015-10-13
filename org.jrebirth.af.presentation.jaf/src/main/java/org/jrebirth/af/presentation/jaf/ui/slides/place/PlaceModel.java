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
package org.jrebirth.af.presentation.jaf.ui.slides.place;

import org.jrebirth.af.presentation.model.Presentation;
import org.jrebirth.af.presentation.model.Speaker;
import org.jrebirth.af.presentation.service.PresentationService;
import org.jrebirth.af.presentation.ui.base.AbstractSlideModel;
import org.jrebirth.af.presentation.ui.base.SlideStep;

/**
 * The class <strong>PlaceModel</strong>.
 *
 * @author Sébastien Bordes
 */
public final class PlaceModel extends AbstractSlideModel<PlaceModel, PlaceView, SlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected SlideStep[] initializeSlideStep() {
        return new SlideStep[0];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final SlideStep slideStep) {
        // Nothing to do yet
    }

    public Presentation getPresentation() {
        return getService(PresentationService.class).getPresentation();
    }

    public String getSpeaker() {
        final StringBuilder sb = new StringBuilder();
        if (getPresentation().getSpeakers() != null && getPresentation().getSpeakers().getSpeaker() != null) {
            for (final Speaker speaker : getPresentation().getSpeakers().getSpeaker()) {
                sb.append(speaker.getFirstName()).
                  append(" ").append(speaker.getLastName());
            }
        }
        return sb.toString();
    }

    public String getEventTime() {
        return getPresentation().getPlace() + " - " + getPresentation().getDate();
    }
}

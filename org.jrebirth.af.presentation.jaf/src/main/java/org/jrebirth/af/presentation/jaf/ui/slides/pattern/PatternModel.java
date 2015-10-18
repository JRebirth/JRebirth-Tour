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
package org.jrebirth.af.presentation.jaf.ui.slides.pattern;

import org.jrebirth.af.presentation.ui.base.AbstractSlideModel;

/**
 * The class <strong>PatternModel</strong>.
 * 
 * @author Sébastien Bordes
 */
public final class PatternModel extends AbstractSlideModel<PatternModel, PatternView, PatternSlideStep> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected PatternSlideStep[] initializeSlideStep() {
        return PatternSlideStep.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showSlideStep(final PatternSlideStep slideStep) {
        switch (slideStep) {

        // case Application:
        // getView().showApp(slideStep.name(), isForwardFlow());
        // break;
        // case GlobalFacade:
        // getView().showGlobalFacade(slideStep.name(), isForwardFlow());
        // break;
        // case Notifier:
        // getView().showNotifier(slideStep.name(), isForwardFlow());
        // break;
        // case Facades:
        // getView().showFacades(slideStep.name(), isForwardFlow());
        // break;
        // case Commands:
        // getView().showCommands(slideStep.name(), isForwardFlow());
        // break;
        // case Services:
        // getView().showServices(slideStep.name(), isForwardFlow());
        // break;
        // case Models:
        // getView().showModels(slideStep.name(), isForwardFlow());
        // break;
        // case Wave:
        // getView().showWave(slideStep.name(), isForwardFlow());
        // break;
        // case Behaviors:
        // getView().showBehaviors(slideStep.name(), isForwardFlow());
        // break;

            default:
                getView().show(slideStep, isForwardFlow());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void showView() {
        getView().initStep();
        super.showView();
    }

}

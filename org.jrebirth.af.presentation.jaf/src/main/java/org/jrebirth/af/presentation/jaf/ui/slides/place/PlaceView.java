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

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.jaf.resources.JpColors;
import org.jrebirth.af.presentation.jaf.resources.JpFonts;
import org.jrebirth.af.presentation.jaf.resources.JpImages;
import org.jrebirth.af.presentation.ui.base.AbstractSlideView;

/**
 *
 * The class <strong>PlaceView</strong>.
 *
 * The custom introduction slide.
 *
 * @author Sébastien Bordes
 */
public final class PlaceView extends AbstractSlideView<PlaceModel, Pane, PlaceController> {

    private Text eventTime;
    private Text speaker;

    /**
     * Default Constructor.
     *
     * @param model the IntroModel view model
     *
     * @throws CoreException if build fails
     */
    public PlaceView(final PlaceModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initView() {

        final ImageView placeImage = new ImageView();
        placeImage.setImage(JpImages.PLACE_BG.get());
        // .fitHeight(Double.MAX_VALUE)
        // .fitWidth(Double.MAX_VALUE)

        final HBox softshake = buildGroup();
        softshake.setLayoutX(50);
        softshake.setLayoutY(50);

        eventTime = new Text();
        eventTime.setFont(JpFonts.CONF_SUBTITLE.get());
        eventTime.setFill(JpColors.SOFT_WHITE.get());
        eventTime.setLayoutX(600);
        eventTime.setLayoutY(700);

        speaker = new Text();
        speaker.setFont(JpFonts.CONF_SUBTITLE.get());
        speaker.setFill(JpColors.SOFT_WHITE.get());
        speaker.setLayoutX(50);
        speaker.setLayoutY(700);

        getRootNode().getChildren().addAll(placeImage, softshake, eventTime, speaker);

        getRootNode().getStyleClass().add(getModel().getSlide().getStyle());
    }

    private HBox buildGroup() {
        final HBox group = new HBox();

        group.getChildren().addAll(
                                   TextBuilder.create().text("{{").font(JpFonts.CONF_TITLE.get()).fill(JpColors.SOFT_BLUE.get()).build(),
                                   TextBuilder.create().text("soft").font(JpFonts.CONF_TITLE.get()).fill(JpColors.SOFT_BLACK.get()).build(),
                                   TextBuilder.create().text("shake").font(JpFonts.CONF_TITLE.get()).fill(JpColors.SOFT_BLUE.get()).build(),
                                   TextBuilder.create().text("}}").font(JpFonts.CONF_TITLE.get()).fill(JpColors.SOFT_BLACK.get()).build()

             );

        return group;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {

        speaker.setText(getModel().getSpeaker());
        eventTime.setText(getModel().getEventTime());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reload() {
        // Nothing to do yet
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hide() {
        // Nothing to do yet
    }
}

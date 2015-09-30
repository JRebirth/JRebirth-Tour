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
package org.jrebirth.af.presentation.jaf.ui.slides.intro;

import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.scene.effect.DropShadowBuilder;
import javafx.scene.effect.GlowBuilder;
import javafx.scene.effect.InnerShadowBuilder;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.ui.base.AbstractSlideView;

/**
 *
 * The class <strong>IntroView</strong>.
 *
 * The custom introduction slide.
 *
 * @author Sébastien Bordes
 */
public final class IntroView extends AbstractSlideView<IntroModel, StackPane, IntroController> {

    /** The typewriter animation. */
    private Timeline typeWriter;
    private Timeline typeWriter2;

    /** The label shown. */
    private Label label;

    private Label sublabel;
    private SequentialTransition globalTypewriter;

    /**
     * Default Constructor.
     *
     * @param model the IntroModel view model
     *
     * @throws CoreException if build fails
     */
    public IntroView(final IntroModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initView() {

        this.label = LabelBuilder
                                 .create()
                                 // .text(getModel().getSlide().getTitle().replaceAll("\\\\n", "\n").replaceAll("\\\\t", "\t"))
                                 // .styleClass("label", "introTitle")
                                 // .font(PrezFonts.TYPEWRITER.get())
                                 // .textFill(Color.BLACK) // web("7F0055")

                                 .textFill(Color.WHITE)
                                 .alignment(Pos.CENTER_LEFT)
                                 .minWidth(800)
                                 .minHeight(500)
                                 .effect(DropShadowBuilder.create()
                                                          .input(
                                                                 GlowBuilder.create()
                                                                            .input(InnerShadowBuilder.create()
                                                                                                     .offsetX(-1)
                                                                                                     .offsetY(-1)
                                                                                                     .color(Color.LIGHTSKYBLUE)
                                                                                                     .build())
                                                                            .level(0.5)
                                                                            .build()
                                                          )
                                                          .offsetX(2)
                                                          .offsetY(2)
                                                          .build())
                                 .build();

        this.label.getStyleClass().add("introTitle");

        this.sublabel = LabelBuilder
                                    .create()
                                    // .text(getModel().getSlide().getTitle().replaceAll("\\\\n", "\n").replaceAll("\\\\t", "\t"))
                                    // .styleClass("label", "introTitle")
                                    // .font(PrezFonts.TYPEWRITER.get())
                                    // .textFill(Color.BLACK) // web("7F0055")

                                    .textFill(Color.WHITE)
                                    .alignment(Pos.CENTER_LEFT)
                                    .minWidth(800)
                                    .minHeight(500)
                                    .effect(DropShadowBuilder.create()
                                                             .input(
                                                                    GlowBuilder.create()
                                                                               .input(InnerShadowBuilder.create()
                                                                                                        .offsetX(-1)
                                                                                                        .offsetY(-1)
                                                                                                        .color(Color.LIGHTSKYBLUE)
                                                                                                        .build())
                                                                               .level(0.5)
                                                                               .build()
                                                             )
                                                             .offsetX(2)
                                                             .offsetY(2)
                                                             .build())
                                    .build();

        this.sublabel.getStyleClass().add("subintroTitle");

        // label.scaleXProperty().bind(Bindings.divide(getModel().getLocalFacade().getGlobalFacade().getApplication().getStage().widthProperty(), 1024));
        // label.scaleYProperty().bind(Bindings.divide(getModel().getLocalFacade().getGlobalFacade().getApplication().getStage().heightProperty(), 768));

        getRootNode().getStyleClass().clear();
        getRootNode().getStyleClass().add(getModel().getSlide().getStyle());

        // final VBox vbox = new VBox();
        // vbox.setPadding(new Insets(50));
        // // vbox.setMinSize(1000, 700);
        // vbox.setStyle(
        // "    -fx-border-color: #000000;\r\n" +
        // "    -fx-border-width: 20px;\r\n" +
        // "    -fx-padding: 10;\r\n" +
        // "    -fx-spacing: 8;\r\n");
        // vbox.getChildren().addAll(label, sublabel);

        getRootNode().getChildren().addAll(this.label, this.sublabel);
        StackPane.setAlignment(this.label, Pos.CENTER);
        StackPane.setAlignment(this.sublabel, Pos.CENTER);

        StackPane.setMargin(this.label, new Insets(-100, 0, 0, 0));
        StackPane.setMargin(this.sublabel, new Insets(150, 0, 0, 0));

        this.typeWriter = buildTypewriter(getModel().getSlide().getTitle().replaceAll("\\\\n", "\n").replaceAll("\\\\t", "\t"), this.label.textProperty(), 90, 130);
        this.typeWriter.setDelay(Duration.millis(300));

        String secondTitle = null;

        if (getModel().getSlide().getContent().size() > 0 && getModel().getSlide().getContent().get(0).getTitle() != null) {
            secondTitle = getModel().getSlide().getContent().get(0).getTitle().replaceAll("\\\\n", "\n").replaceAll("\\\\t", "\t");
            this.typeWriter2 = buildTypewriter(secondTitle, this.sublabel.textProperty(), 90, 70);
        }

        this.globalTypewriter = new SequentialTransition();
        this.globalTypewriter.getChildren().add(this.typeWriter);
        if (this.typeWriter2 != null) {
            this.globalTypewriter.getChildren().add(this.typeWriter2);
        }
    }

    /**
     * TODO To complete.
     */
    private Timeline buildTypewriter(final String text, final StringProperty property, final int min, final int max) {
        final Timeline typeWriter = new Timeline();

        String content = "";
        Duration d = Duration.ZERO;
        final Random r = new Random();

        for (final char c : text.toCharArray()) {

            d = d.add(Duration.millis(r.nextInt(Integer.MAX_VALUE) % min + max));
            typeWriter.getKeyFrames().add(new KeyFrame(d, new KeyValue(property, new String(content + c))));
            content += c;
        }

        return typeWriter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        reload();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reload() {

        this.globalTypewriter.play();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hide() {
        this.globalTypewriter.jumpTo(Duration.ZERO);

    }

}

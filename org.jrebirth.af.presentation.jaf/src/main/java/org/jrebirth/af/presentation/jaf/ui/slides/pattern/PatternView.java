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

import java.util.HashMap;
import java.util.Map;

import javafx.animation.Animation;
import javafx.animation.FadeTransitionBuilder;
import javafx.animation.ParallelTransitionBuilder;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import javafx.util.Duration;

import org.jrebirth.af.api.exception.CoreException;
import org.jrebirth.af.presentation.jaf.resources.JpFonts;
import org.jrebirth.af.presentation.ui.base.AbstractSlideView;

/**
 * 
 * The class <strong>PatternView</strong>.
 * 
 * The custom introduction slide.
 * 
 * @author Sébastien Bordes
 */
public final class PatternView extends AbstractSlideView<PatternModel, Pane, PatternController> {

    private static final int BIG_RADIUS = 30;
    private static final int SMALL_RADIUS = 20;

    private final Map<PatternSlideStep, Animation> stepAnimations = new HashMap<>();

    private final Map<String, Node> stepBalls = new HashMap<>();

    private final Map<String, Line> stepLines = new HashMap<>();

    private DropShadow dropShadow = null;

    private final Pane linkLayer = new Pane();

    private final Pane ballLayer = new Pane();

    /**
     * Default Constructor.
     * 
     * @param model the controls view model
     * 
     * @throws CoreException if build fails
     */
    public PatternView(final PatternModel model) throws CoreException {
        super(model);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void initView() {
        super.initView();

    }

    /**
     * TODO To complete.
     * 
     * @param dropShadow
     * @return
     */
    protected DropShadow getDropShadow() {

        if (dropShadow == null) {
            dropShadow = new DropShadow();
            dropShadow.setRadius(5.0);
            dropShadow.setOffsetX(3.0);
            dropShadow.setOffsetY(3.0);
            dropShadow.setColor(Color.BLACK);
        }
        return dropShadow;
    }

    public void show(PatternSlideStep step, boolean forward) {

        final Animation stepAnimation = stepAnimations.get(step);
        if (stepAnimation != null) {

            if (forward) {
                stepAnimation.setRate(1);
                stepAnimation.playFromStart();
            } else {
                stepAnimation.setRate(-1);
                stepAnimation.playFrom(stepAnimation.getCycleDuration());
            }
        }

    }

    public void initStep() {
        getRootNode().setPrefSize(1024, 768);
        getRootNode().setMaxSize(1024, 768);
        getRootNode().setMinSize(1024, 768);

        linkLayer.setPrefSize(1024, 768);
        linkLayer.setMaxSize(1024, 768);
        linkLayer.setMinSize(1024, 768);

        ballLayer.setPrefSize(1024, 768);
        ballLayer.setMaxSize(1024, 768);
        ballLayer.setMinSize(1024, 768);

        getRootNode().getChildren().addAll(linkLayer, ballLayer);

        // Application
        final Point2D gfPoint = new Point2D(getRootNode().getPrefWidth() / 2, getRootNode().getPrefHeight() / 2);
        final Node a = buildBall("A", BallColors.APPLICATION.get(), gfPoint.add(75, 75), true);

        // GlobalFacade
        final Node gf = buildBall("GF", BallColors.GLOBAL_FACADE.get(), gfPoint, true);
        final Node gfLink = buildLink(gf, a, true, true);

        // Notifier
        final Point2D nPoint = gfPoint.add(75, -75);
        final Node n = buildBall("N", BallColors.NOTIFIER.get(), nPoint, true);
        final Node nLink = buildLink(n, gf, true, true);

        // Service
        final Point2D sfPoint = getNextPoint(gfPoint, 200, Math.PI * 2 / 3);
        final Node sf = buildBall("SF", BallColors.SERVICE_FACADE.get(), sfPoint, true);
        final Node sfLink = buildLink(sf, gf, true, true);

        final Node s1 = buildBall("S", BallColors.SERVICE.get(), getNextPoint(sfPoint, 100, Math.PI), false);
        final Node s1Link = buildLink(s1, sf, false, true);
        final Node s2 = buildBall("S", BallColors.SERVICE.get(), getNextPoint(sfPoint, 100, Math.PI * 2 / 3), false);
        final Node s2Link = buildLink(s2, sf, false, true);
        final Node s3 = buildBall("S", BallColors.SERVICE.get(), getNextPoint(sfPoint, 100, Math.PI / 3), false);
        final Node s3Link = buildLink(s3, sf, false, true);

        // Commands
        final Point2D cfPoint = getNextPoint(gfPoint, 200, -Math.PI * 2 / 3);
        final Node cf = buildBall("CF", BallColors.COMMAND_FACADE.get(), cfPoint, true);
        final Node cfLink = buildLink(cf, gf, true, true);

        final Point2D mcPoint = getNextPoint(cfPoint, 100, -Math.PI * 2 / 3);
        final Node c2 = buildBall("MC", BallColors.MULTI_COMMAND.get(), mcPoint, false);
        final Node c2Link = buildLink(c2, cf, false, true);
        final Node mc1 = buildBall("C", BallColors.COMMAND.get(), getNextPoint(mcPoint, 80, -Math.PI * 7 / 8), false);
        final Node mc1Link = buildLink(mc1, c2, false, false);
        final Node mc2 = buildBall("C", BallColors.COMMAND.get(), getNextPoint(mcPoint, 80, -Math.PI * 3 / 8), false);
        final Node mc2Link = buildLink(mc2, c2, false, false);

        final Node c1 = buildBall("C", BallColors.COMMAND.get(), getNextPoint(cfPoint, 100, -Math.PI), false);
        final Node c1Link = buildLink(c1, cf, false, true);

        final Node c3 = buildBall("C", BallColors.COMMAND.get(), getNextPoint(cfPoint, 100, -Math.PI / 3), false);
        final Node c3Link = buildLink(c3, cf, false, true);

        // Models
        final Point2D ufPoint = getNextPoint(gfPoint, 200, 2 * Math.PI);
        final Node uf = buildBall("UF", BallColors.UI_FACADE.get(), ufPoint, true);
        final Node ufLink = buildLink(uf, gf, true, true);

        final Point2D m1Point = getNextPoint(ufPoint, 100, -Math.PI / 3);
        final Node m1 = buildBall("M", BallColors.MODEL.get(), m1Point, false);
        final Node m1Link = buildLink(m1, uf, false, true);

        final Node v1 = buildBall("V", BallColors.VIEW.get(), getNextPoint(m1Point, 80, -Math.PI * 2 / 3), false);
        final Node v1Link = buildLink(v1, m1, false, false);
        final Node ct = buildBall("C", BallColors.CONTROLLER.get(), getNextPoint(m1Point, 80, -Math.PI / 3), false);
        final Node ctLink1 = buildLink(ct, m1, false, false);
        final Node ctLink2 = buildLink(ct, v1, false, false);

        final Point2D m2Point = getNextPoint(ufPoint, 100, 2 * Math.PI);
        final Node m2 = buildBall("M", BallColors.MODEL.get(), m2Point, false);
        final Node m2Link = buildLink(m2, uf, false, true);
        final Node v2 = buildBall("V", BallColors.VIEW.get(), getNextPoint(m2Point, 80, 2 * Math.PI), false);
        final Node v2Link = buildLink(v2, m2, false, false);

        final Point2D m3Point = getNextPoint(ufPoint, 100, Math.PI / 3);
        final Node m3 = buildBall("M", BallColors.MODEL.get(), m3Point, false);
        final Node m3Link = buildLink(m3, uf, false, true);

        final Node fx = buildBall("F", BallColors.VIEW.get(), getNextPoint(m3Point, 80, Math.PI * 2 / 3), false);
        final Node fxLink = buildLink(fx, m3, false, false);
        final Node fxc = buildBall("FC", BallColors.CONTROLLER.get(), getNextPoint(m3Point, 80, Math.PI / 3), false);
        final Node fxcLink1 = buildLink(fxc, fx, false, false);
        final Node fxcLink2 = buildLink(fxc, m3, false, false);

        // Behaviors
        final Point2D bfPoint = getNextPoint(gfPoint, 260, Math.PI);
        final Node bf = buildBall("BF", BallColors.BEHAVIOR_FACADE.get(), bfPoint, true);
        final Node bfLink = buildLink(bf, gf, true, true);

        final Node b1 = buildBall("B", BallColors.BEHAVIOR.get(), getNextPoint(bfPoint, 100, -Math.PI * 2 / 3), false);
        final Node b1Link = buildLink(b1, bf, false, true);
        final Node b2 = buildBall("B", BallColors.BEHAVIOR.get(), getNextPoint(bfPoint, 100, Math.PI), false);
        final Node b2Link = buildLink(b2, bf, false, true);
        final Node b3 = buildBall("B", BallColors.BEHAVIOR.get(), getNextPoint(bfPoint, 100, Math.PI * 2 / 3), false);
        final Node b3Link = buildLink(b3, bf, false, true);

        // Waves
        final Point2D wPoint = getNextPoint(nPoint, 220, -Math.PI / 2);
        final Node w = buildBall("W", BallColors.UI_FACADE.get(), wPoint, false);
        final Node wLink = buildArc(nPoint, c3, v1, true, true);

        // Application Animation
        stepAnimations.put(PatternSlideStep.Application, buildFade(a));

        // Global facade
        stepAnimations.put(PatternSlideStep.GlobalFacade, getParallel(buildFade(gf), buildFade(gfLink)));

        // Notifier
        stepAnimations.put(PatternSlideStep.Notifier, getParallel(buildFade(n), buildFade(nLink)));

        // Facades
        stepAnimations.put(PatternSlideStep.Facades, getParallel(buildFade(cf), buildFade(cfLink), buildFade(sf), buildFade(sfLink), buildFade(uf), buildFade(ufLink)));

        // Services
        stepAnimations.put(PatternSlideStep.Services, getParallel(buildFade(s1), buildFade(s1Link), buildFade(s2), buildFade(s2Link), buildFade(s3), buildFade(s3Link)));

        // Commands
        stepAnimations.put(PatternSlideStep.Commands, getParallel(buildFade(c1), buildFade(c1Link), buildFade(c2), buildFade(c2Link), buildFade(c3), buildFade(c3Link),
                                                                  buildFade(mc1), buildFade(mc1Link), buildFade(mc2), buildFade(mc2Link)));

        // Models
        stepAnimations.put(PatternSlideStep.Models, getParallel(buildFade(m1), buildFade(m1Link), buildFade(m2), buildFade(m2Link), buildFade(m3), buildFade(m3Link),
                                                                buildFade(v1), buildFade(v1Link), buildFade(ct), buildFade(ctLink1), buildFade(ctLink2),
                                                                buildFade(v2), buildFade(v2Link),
                                                                buildFade(fx), buildFade(fxc), buildFade(fxLink), buildFade(fxcLink1), buildFade(fxcLink2)));

        // Behavior
        stepAnimations.put(PatternSlideStep.Behaviors,
                           getParallel(buildFade(bf), buildFade(bfLink), buildFade(b1), buildFade(b1Link), buildFade(b2), buildFade(b2Link), buildFade(b3), buildFade(b3Link)));

        // Wave
        stepAnimations.put(PatternSlideStep.Wave, getParallel(buildFade(w), buildFade(wLink)));

    }

    private Point2D getNextPoint(Point2D point, int distance, double angle) {
        return point.add(distance * Math.cos(angle), distance * Math.sin(angle));
    }

    private Node buildBall(String name, Color color, Point2D point, boolean big) {
        final StackPane ball = new StackPane();

        final int radius = big ? BIG_RADIUS : SMALL_RADIUS;

        ball.relocate(point.getX() - radius, point.getY() - radius);

        final Circle c = new Circle(radius);
        c.setFill(color);
        c.setStroke(Color.WHITE);
        c.setStrokeWidth(4);
        c.setStrokeType(StrokeType.OUTSIDE);

        final Text t = new Text(name);
        t.setFont(big ? JpFonts.BIG_PATTERN.get() : JpFonts.SMALL_PATTERN.get());
        t.setFill(Color.WHITE);
        t.setStroke(Color.DARKGRAY);
        c.setStrokeWidth(1);
        c.setStrokeType(StrokeType.OUTSIDE);

        StackPane.setAlignment(c, Pos.CENTER);
        StackPane.setAlignment(t, Pos.CENTER);
        ball.getChildren().addAll(c, t);

        ball.setEffect(getDropShadow());
        ball.setOpacity(0.0);

        ballLayer.getChildren().add(ball);

        return ball;
    }

    private Node buildLink(Node n1, Node n2, boolean bigDestination, boolean bigSource) {

        final int sourceRadius = bigSource ? BIG_RADIUS : SMALL_RADIUS;
        final int destRadius = bigDestination ? BIG_RADIUS : SMALL_RADIUS;

        final Line line = new Line();

        line.startXProperty().bind(n1.layoutXProperty().add(destRadius));
        line.startYProperty().bind(n1.layoutYProperty().add(destRadius));

        line.endXProperty().bind(n2.layoutXProperty().add(sourceRadius));
        line.endYProperty().bind(n2.layoutYProperty().add(sourceRadius));

        line.setFill(Color.WHITE);
        line.setStrokeWidth(4);
        line.setStroke(Color.WHITE);
        line.setEffect(getDropShadow());

        line.setOpacity(0.0);
        linkLayer.getChildren().add(line);

        return line;
    }

    private Node buildArc(Point2D point, Node n1, Node n2, boolean bigDestination, boolean bigSource) {

        final int sourceRadius = bigSource ? BIG_RADIUS : SMALL_RADIUS;
        final int destRadius = bigDestination ? BIG_RADIUS : SMALL_RADIUS;

        final QuadCurve cubic = new QuadCurve();

        cubic.startXProperty().bind(n1.layoutXProperty().add(destRadius));
        cubic.startYProperty().bind(n1.layoutYProperty().add(destRadius));
        cubic.endXProperty().bind(n2.layoutXProperty().add(sourceRadius));
        cubic.endYProperty().bind(n2.layoutYProperty().add(sourceRadius));

        cubic.setControlX(point.getX());
        cubic.setControlY(0);

        cubic.setFill(Color.TRANSPARENT);
        cubic.setStrokeWidth(4);
        cubic.setStroke(Color.WHITE);
        // cubic.setEffect(getDropShadow());

        cubic.setOpacity(0.0);
        linkLayer.getChildren().add(cubic);

        return cubic;
    }

    /**
     * TODO To complete.
     * 
     * @param gf
     * @return
     */
    protected Animation getParallel(final Animation... animation) {
        return ParallelTransitionBuilder.create().children(animation).build();
    }

    /**
     * TODO To complete.
     */
    protected Animation buildFade(Node node) {
        return FadeTransitionBuilder.create().duration(Duration.millis(1000)).fromValue(0.0).toValue(1.0).node(node).build();
    }

    public void showApp(PatternSlideStep name, boolean forwardFlow) {
        // Nothing to do yet

    }

    public void showGlobalFacade(String name, boolean forwardFlow) {
        // Nothing to do yet

    }

    public void showNotifier(String name, boolean forwardFlow) {
        // Nothing to do yet

    }

    public void showFacades(String name, boolean forwardFlow) {
        // Nothing to do yet

    }

    public void showCommands(String name, boolean forwardFlow) {
        // Nothing to do yet

    }

    public void showServices(String name, boolean forwardFlow) {
        // Nothing to do yet

    }

    public void showModels(String name, boolean forwardFlow) {
        // Nothing to do yet

    }

    public void showWave(String name, boolean forwardFlow) {
        // Nothing to do yet

    }

    public void showBehaviors(String name, boolean forwardFlow) {
        // Nothing to do yet

    }

}

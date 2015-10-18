package org.jrebirth.af.presentation.jaf.ui.slides.pattern;

import javafx.scene.paint.Color;

import org.jrebirth.af.api.resource.color.ColorParams;
import org.jrebirth.af.core.resource.ResourceBuilders;
import org.jrebirth.af.core.resource.color.ColorBuilder;
import org.jrebirth.af.core.resource.color.ColorItemReal;
import org.jrebirth.af.core.resource.color.WebColor;

/**
 * The class <strong>BallColors</strong>.
 *
 * @author Sébastien Bordes
 *
 */
public enum BallColors implements ColorItemReal {

    /** The application ball background color. */
    APPLICATION(new WebColor("70CD43")),

    /** The notifier ball background color. */
    NOTIFIER(new WebColor("FDFD89")),

    /** The global facade ball background color. */
    GLOBAL_FACADE(new WebColor("FC1A9C")),

    /** The command facade ball background color. */
    COMMAND_FACADE(new WebColor("963593")),

    /** The service facade ball background color. */
    SERVICE_FACADE(new WebColor("FD1CFD")),

    /** The UI Facade ball background color. */
    UI_FACADE(new WebColor("FD2C33")),

    /** The Command ball background color. */
    COMMAND(new WebColor("D9E032")),

    /** The Service ball background color. */
    SERVICE(new WebColor("FAED30")),

    /** The Model ball background color. */
    MODEL(new WebColor("F1693A")),

    /** The View ball background color. */
    VIEW(new WebColor("4AACF2"));

    /**
     * Private Constructor.
     *
     * @param colorParams the primitive values for the color
     */
    private BallColors(final ColorParams colorParams) {
        builder().storeParams(this, colorParams);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color get() {
        return builder().get(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ColorBuilder builder() {
        return ResourceBuilders.COLOR_BUILDER;
    }
}

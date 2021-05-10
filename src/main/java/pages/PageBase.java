package pages;

import utils.AutomatedWebTool;

public class PageBase {
    protected AutomatedWebTool tool;

    public PageBase(AutomatedWebTool tool) {
        this.tool = tool;
    }

    public String getPageUrl() {
        return site.CodePen.siteUrl;
    }
}

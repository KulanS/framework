/* 
@ITMillApache2LicenseForJavaFiles@
 */
package com.vaadin.tests.components.tree;

import com.vaadin.data.Container;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.data.validator.AbstractValidator;
import com.vaadin.tests.components.TestBase;
import com.vaadin.ui.Tree;

public class TreeKeyboardNavigationScrolls extends TestBase {

    @Override
    protected void setup() {
        Tree tree = new Tree();
        tree.setContainerDataSource(generateHierarchicalContainer());
        tree.setImmediate(true);
        tree.addValidator(new AbstractValidator("failed") {
            public boolean isValid(Object value) {
                return false;
            }

        });
        addComponent(tree);
    }

    private Container generateHierarchicalContainer() {
        HierarchicalContainer cont = new HierarchicalContainer();
        for (int i = 1; i < 6; i++) {
            cont.addItem(i);
            for (int j = 1; j < 3; j++) {
                String id = i
                        + " foo bar baz make this node really wide so that we don't have to fiddle with resizing the browser window -> what would you do if you had one of your legs on backwards? it's legs time! everybody get your legs! "
                        + j;
                cont.addItem(id);
                cont.setChildrenAllowed(id, false);
                cont.setParent(id, i);
            }
        }
        return cont;
    }

    @Override
    protected String getDescription() {
        return "The tree scrolls right if the focused node is too wide when navigating with the keyboard";
    }

    @Override
    protected Integer getTicketNumber() {
        return 7230;
    }

}

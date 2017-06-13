package simpleGfx.screens;

/**
 * Basic implementation of a ScreenManager
 * Works like a stack, last screen is the one shown in the screen
 * If we want the screen before, it just pops the last one and
 * returns it in case we want to use for something else
 *
 * @author João David Silva
 */

public class ScreenManager {

    private ScreenNode head;

    public void changeScreen() {

    }

    public void push(Screen element) {
        if (head == null) {
            head = new ScreenNode(element);
            return;
        }
    }

    public Screen pop() {
        if(head == null) {
            return null;
        }

        if(head.getNextNode() == null) {
            Screen temp = head.getElement();
            head = null;
            return temp;
        }

        return head.pop();
    }

    public int size() {
        if(head == null) {
            return 0;
        }

        return head.size(1);
    }

    public Screen getElement(int index) {
        if(head == null) {
            return null;
        }

        return head.getElement(index);
    }

    public void remove(int index) {
        if(head == null) {
            return;
        }

        if(index == 0) {
            if(head.getNextNode() == null) {
                head = null;
                return;
            }
            head = head.getNextNode();
            return;
        }

        head.remove(index);
    }

    private class ScreenNode {

        private ScreenNode next;
        private Screen element;

        public ScreenNode(Screen element) {
            this.element = element;
        }

        public void push(Screen element) {
            if(next == null) {
                next = new ScreenNode(element);
                return;
            }

            next.push(element);
        }

        public Screen pop() {
            if(next == null) {
                return null;
            }

            if(next.getNextNode() == null) {
                Screen temp = next.getElement();
                next = null;
                return temp;
            }

            return next.pop();
        }

        public int size(int before) {
            if(next == null) {
                return 1;
            }

            return next.size(before) + 1;
        }

        public ScreenNode getNextNode() {
            return next;
        }

        public Screen getElement() {
            return element;
        }

        public Screen getElement(int index) {
            if(index < 1) {
                return element;
            }

            if(index == 1 && next == null) {
                return null;
            }

            return next.getElement(index - 1);
        }

        public void remove(int index) {
            if(next == null && index > 0) {
                return;
            }

            if(index == 1) {
                if(next.getNextNode() == null) {
                    next = null;
                    return;
                }
                next = next.getNextNode();
                return;
            }

            next.remove(index - 1);
        }
    }
}

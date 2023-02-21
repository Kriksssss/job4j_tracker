package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StartUITest {
    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. === Edit item ===" + ln
                        + "1. === Exit ===" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu." + ln
                        + "0. === Edit item ===" + ln
                        + "1. === Exit ===" + ln
        );
    }

    @Test
    public void whenFindAllActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = new UserAction[]{
                new ShowAllAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. === Show all items ===" + ln
                        + "1. === Exit ===" + ln
                        + "=== Show all items ===" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. === Show all items ===" + ln
                        + "1. === Exit ===" + ln
        );
    }

    @Test
    public void whenFindByNameActionTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String byName = "test1";
        Input in = new StubInput(
                new String[]{"0", byName, "1"}
        );
        UserAction[] actions = new UserAction[]{
                new FindByNameAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                        + "0. === Find items by name ===" + ln
                        + "1. === Exit ===" + ln
                        + one + ln
                        + "Menu." + ln
                        + "0. === Find items by name ===" + ln
                        + "1. === Exit ===" + ln
        );
    }

        @Test
        public void whenFindByIdActionTestOutputIsSuccessfully() {
            Output out = new StubOutput();
            Tracker tracker = new Tracker();
            Item one = tracker.add(new Item("test1"));
            Input in = new StubInput(
                    new String[]{"0", String.valueOf(one.getId()), "1"}
            );
            UserAction[] actions = new UserAction[]{
                    new FindByIdAction(out),
                    new ExitAction(out)
            };
            new StartUI(out).init(in, tracker, actions);
            String ln = System.lineSeparator();
            assertThat(out.toString()).isEqualTo(
                    "Menu." + ln
                            + "0. === Find item by id ===" + ln
                            + "1. === Exit ===" + ln
                            + one + ln
                            + "Menu." + ln
                            + "0. === Find item by id ===" + ln
                            + "1. === Exit ===" + ln
            );
        }
}
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void testWarriorMove() {
        Warrior warrior = new Warrior();
        assertEquals("Warrior moves forward", warrior.move());
    }

    @Test
    public void testMageMove() {
        Mage mage = new Mage();
        assertEquals("Mage teleports", mage.move());
    }

    @Test
    public void testRogueMove() {
        Rogue rogue = new Rogue();
        assertEquals("Rogue sneaks", rogue.move());
    }
}
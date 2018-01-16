package Przyrost3.entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class WarriorTest {
    @Test
    public void getFullPower() throws Exception {
        Technique kamehamehaTechnique = new Technique();
        kamehamehaTechnique.setName("Kamehameha");
        kamehamehaTechnique.setPercentagetopower(30);

        Technique kamehamehaTechnique2 = new Technique();
        kamehamehaTechnique.setName("Kamehameha x2");
        kamehamehaTechnique.setPercentagetopower(60);

        Technique kamehamehaTechnique3 = new Technique();
        kamehamehaTechnique.setName("Kamehameha x3");
        kamehamehaTechnique.setPercentagetopower(90);

        Nickname nickname = new Nickname();
        nickname.setName("Kakarot");

        FightingSchool fightingSchool = new FightingSchool();
        fightingSchool.setName("Szkoła Żółwia");
        fightingSchool.setPercentagetopower(10);

        Wife wife=new Wife();
        wife.setName("Chi Chi");
        wife.setSurname("Gokówna");
        wife.setPercentagetopower(5);

        Warrior warrior = new Warrior();
        warrior.setName("Goku");
        warrior.setSurname("Son");
        warrior.setNickname(nickname);
        warrior.setPower(9008);
        warrior.getTechniques().add(kamehamehaTechnique);
        warrior.getTechniques().add(kamehamehaTechnique3);
        warrior.getTechniques().add(kamehamehaTechnique2);
        warrior.setFightingschool(fightingSchool);
        warrior.setWife(wife);
        int result=warrior.getFullPower();
        assertEquals(result,19768);
    }

}
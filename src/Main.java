public class Main {
    public static void main(String[] args) {
        RPGCharacter GiGi = new RPGCharacter(3, 6.0);
        RPGCharacter Lord = new RPGCharacter(10, 10.0);
        Sword sword = new Sword(12);
        Sword spear = new Sword(10);
        Shield shield = new Shield(8);

        Lord.GetSword(sword);
        GiGi.GetSword(spear);
        Lord.GetShield(shield);
        Lord.LostShield();


        Lord.Stat();
        System.out.println("----------------------------------------");


        Lord.fight(Lord, GiGi);
        Lord.Stat();
        System.out.println("----------------------------------------");
        Lord.Heal();
        Lord.Stat();
        System.out.println("---------------------------------------");
        Lord.RegenMana();
        Lord.Stat();
        System.out.println("---------------------------------------");
        sword.SwordBaseDamage = 1000.0;
        Lord.fight(Lord, GiGi);
        Lord.Stat();

        /*System.out.println("---------------------------------------");
        Lord.LostSword();
        spear.SwordBaseDamage=100.0;
        Lord.fight(Lord, GiGi);
        Lord.Stat();
        System.out.println("--------------------------------------");
        Lord.ExtraHeal();
        Lord.Stat();
        System.out.println("--------------------------------------");
        Lord.fight(Lord, GiGi);
        Lord.Stat();
        System.out.println("--------------------------------------");
        Lord.Hi();
        System.out.println("---------------------------------------");
        Lord.OhGod(Lord);
        Lord.Stat();
        System.out.println("---------------------------------------");
        GiGi.Stat();
        System.out.println("---------------------------------------");
        Lord.ByeBye(GiGi);
        GiGi.Stat();
        System.out.println("---------------------------------------");
        Lord.Stat();
        System.out.println("---------------------------------------");
        Lord.RegenMana();
        Lord.Stat();
        System.out.println("---------------------------------------");
        Lord.Help(Lord);
        Lord.Stat();
        System.out.println("---------------------------------------");*/




    }
}
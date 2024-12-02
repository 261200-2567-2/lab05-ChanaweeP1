public class RPGCharacter implements MainCharacter , Summon , RingofDeath , RingofAngel {
    private int level;
    private double MaxHP;
    private double MaxMana;
    private double Run_Speed;
    private double Mana;
    private double Hp ;
    private int Coin = 5;
    private int Scroll = 10;

    public Sword sword;
    public Shield shield;



    protected boolean Heal = false;
    protected boolean ExtraHeal = false;
    protected boolean RegenMana = false;
    protected boolean Hi = false;
    protected boolean Help = false;
    protected boolean ROD = true;
    protected boolean ROA  = true;

    public RPGCharacter(int level, double Run_speed) {
        this.level = level;
        this.Run_Speed = Run_speed;
        Stat_up();
        this.Hp = MaxHP;
        this.Mana=MaxMana;
    }

    private void Stat_up() {
        this.MaxHP = 100 + 10 * level;
        this.MaxMana = 50 + 2 * level;
    }

    public void GetSword(Sword sword) {
        this.sword = sword;
    }

    public void GetShield(Shield shield) {
        this.shield = shield;
    }

    public void LostSword() {
        this.sword = null;
    }

    public void LostShield() {
        this.shield = null;
    }

    public double GetSwordDamage() {
        if (sword != null) {
            return sword.TakeDamage() * (1 + 0.1 * level);
        } else {
            return 0;
        }
    }

    public double GetSheildDefense() {
        if (shield != null) {
            return shield.gotShield() * (1 + 0.05 * level);

        } else {
            return 0;
             }
        }


    public double getRun_Speed() {
        double run_speed = Run_Speed * (1 + 0.03 * level);
        if (sword != null) {
            run_speed = Run_Speed - (Run_Speed * (0.1 + 0.04 * level));
        }
        if (shield != null) {
            run_speed = Run_Speed - (Run_Speed * (0.1 + 0.08 * level));
        }
        return run_speed;
    }

    public void LevelUp() {
        level++;
        Coin += 15;
        Scroll += 20;
        Mana +=40;
        Stat_up();
        if(Mana>MaxMana){
            Mana=MaxMana;
        }
    }

    public void fight(RPGCharacter Lord, RPGCharacter Mons) {
        Mons.Hp = 100;
        if (Lord.getRun_Speed() >= Mons.getRun_Speed() && Lord.Mana >= 8) {
            Lord.Mana -= 8;
            Mons.Hp -= Lord.GetSwordDamage();
            if (Lord.shield != null) {
                Lord.Hp -= Mons.GetSwordDamage() * (0.05 * Lord.GetSheildDefense());
            } else {
                Lord.Hp -= Mons.GetSwordDamage();
            }
            if (Mons.Hp <= 0) {
                Lord.LevelUp();
            }
        }
    }



    public int getLevel() {
        return level;
    }

    public double getHP() {
        return Hp;
    }

    public double getMana() {
        return Mana;
    }
    public double getCoin() {
        return Coin;
    }
    public int getScroll() {
        return Scroll;
    }


    public void Stat() {
        System.out.println("Level " + getLevel());
        System.out.println("Hp " + getHP());
        System.out.println("Mana " + getMana());
        System.out.println("Sword Damage " + GetSwordDamage());
        System.out.println("Shield " + GetSheildDefense());
        System.out.println("Run Speed " + getRun_Speed());
        System.out.println("Coin " + getCoin());
        System.out.println("Scroll " + getScroll());
    }


    @Override
    public void Heal() {
        if (Coin >= 0 && Mana >= 15 && Scroll >= 2) {
            Coin -= 1;
            Mana -= 15;
            Hp += 30;
            if(Hp >= MaxHP){
                Hp = MaxHP;
            }
            Heal = true;
            System.out.println("Heal");
        }
        else {
            System.out.println("No mana");
        }
    }

    @Override
    public void ExtraHeal() {
        if (Coin >= 3 && Mana >= 45 && Scroll >= 4) {
            Coin -= 3;
            Mana -= 45;
            Scroll -=4;
            Hp = MaxHP;
            ExtraHeal = true;
            System.out.println("ExtraHeal");
        }
        else {
            System.out.println("No mana");
        }
    }

    @Override
    public void RegenMana(){
        if (Coin >= 1  && Scroll >= 2) {
            Coin -= 1;
            Scroll -= 2;
            RegenMana = true;
                Mana += 30;
                if(Mana > MaxMana){
                    Mana = MaxMana;
            }
            System.out.println("RegenMana");
        }
        else {
            System.out.println("No mana");
        }
    }
    @Override
    public void Hi() {
        if (Mana >= 35  && Scroll >= 3) {
            Mana -= 35;
            Scroll -= 3;
            Hi = true;
            System.out.println("You have a frined");
        }
        else {
            System.out.println("No mana");
        }
    }

    @Override
    public void Help(RPGCharacter character){
        if(Mana >= 10) {
            Mana -= 10;
            Help = true;
            for(int i = 0 ; i<3 ; i++) {
                character.Hp += 5;
            }
            }
        }
    @Override
    public void LetGo(RPGCharacter Mons){
        if(Mana >= 15){
            Mana -= 15;
            for(int i = 0 ; i<5 ; i++) {
                Mons.Hp -=3;
            }
        }
    }
    @Override
    public void ByeBye(RPGCharacter Mons){
        ROD = false;
        Mons.Hp -=(Mons.Hp*0.60);
    }
    @Override
    public void OhGod(RPGCharacter character){
        ROA = false;
        character.Hp +=Hp*0.5;
    }
}


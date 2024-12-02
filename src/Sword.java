class Sword {
    public double SwordBaseDamage;

    public Sword(double SwordBaseDamage) {
        this.SwordBaseDamage = SwordBaseDamage;
    }

    public double TakeDamage() {
        return SwordBaseDamage;
    }
}

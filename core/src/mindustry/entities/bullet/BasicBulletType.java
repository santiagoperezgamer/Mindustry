package mindustry.entities.bullet;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import mindustry.entities.type.*;
import mindustry.graphics.*;

/** An extended BulletType for most ammo-based bullets shot from turrets and units. */
public class BasicBulletType extends BulletType{
    public Color backColor = Pal.bulletYellowBack, frontColor = Pal.bulletYellow;
    public float bulletWidth = 5f, bulletHeight = 7f;
    public float bulletShrink = 0.5f;
    public String bulletSprite;

    public TextureRegion backRegion;
    public TextureRegion frontRegion;

    public BasicBulletType(float speed, float damage, String bulletSprite){
        super(speed, damage);
        this.bulletSprite = bulletSprite;
    }

    /** For mods. */
    public BasicBulletType(){
        this(1f, 1f, "bullet");
    }

    @Override
    public void load(){
        backRegion = Core.atlas.find(bulletSprite + "-back");
        frontRegion = Core.atlas.find(bulletSprite);
    }

    @Override
    public void draw(Bullet b){
        float height = bulletHeight * ((1f - bulletShrink) + bulletShrink * b.fout());

        Draw.color(backColor);
        Draw.rect(backRegion, b.x, b.y, bulletWidth, height, b.rot() - 90);
        Draw.color(frontColor);
        Draw.rect(frontRegion, b.x, b.y, bulletWidth, height, b.rot() - 90);
        Draw.color();
    }
}

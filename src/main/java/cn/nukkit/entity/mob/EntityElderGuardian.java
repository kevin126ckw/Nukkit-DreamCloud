package cn.nukkit.entity.mob;

import cn.nukkit.entity.Entity;
import cn.nukkit.entity.EntityCreature;
import cn.nukkit.entity.EntityUtils;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.item.Item;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

import java.util.ArrayList;
import java.util.List;

public class EntityElderGuardian extends EntitySwimmingMob {

  public static final int NETWORK_ID = 50;

  public EntityElderGuardian(FullChunk chunk, CompoundTag nbt) {
      super(chunk, nbt);
  }

  @Override
  public int getNetworkId() {
      return NETWORK_ID;
  }

  @Override
  public float getWidth() {
      return 1.9975f;
  }

  @Override
  public float getHeight() {
      return 1.9975f;
  }

  @Override
  public void initEntity() {
      super.initEntity();

      this.setMaxHealth(80);
  }

  @Override
  public boolean targetOption(EntityCreature creature, double distance) {
      return false;
  }

  @Override
  public void attackEntity(Entity player) {
  }

  @Override
  public Item[] getDrops() {
      List<Item> drops = new ArrayList<>();
      if (this.lastDamageCause instanceof EntityDamageByEntityEvent) {
          int prismarineShard = EntityUtils.rand(0, 3);
          for (int i = 0; i < prismarineShard; i++) {
              drops.add(Item.get(Item.PRISMARINE_SHARD, 0, 1));
          }
      }
      return drops.toArray(new Item[drops.size()]);
  }

  @Override
  public int getKillExperience() {
      return 10;
  }
}

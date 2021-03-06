package misat11.bw.api;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Villager;

public class GameStore {

	private final Location loc;
	private final String shop;
	private final String shopName;
	private final boolean enableCustomName;
	private final boolean useParent;
	private LivingEntity entity;
	private EntityType type;

	public GameStore(Location loc, String shop, boolean useParent, String shopName, boolean enableCustomName) {
		this(loc, shop, useParent, EntityType.VILLAGER, shopName, enableCustomName);
	}

	public GameStore(Location loc, String shop, boolean useParent, EntityType type, String shopName, boolean enableCustomName) {
		if (type == null || !type.isAlive()) {
			type = EntityType.VILLAGER;
		}
		this.loc = loc;
		this.shop = shop;
		this.useParent = useParent;
		this.type = type;
		this.shopName = shopName;
		this.enableCustomName = enableCustomName;
	}

	public LivingEntity spawn() {
		if (entity == null) {
			entity = (LivingEntity) loc.getWorld().spawnEntity(loc, type);
			if (enableCustomName) {
				entity.setCustomName(shopName);
				entity.setCustomNameVisible(true);
			}
			if (entity instanceof Villager) {
				((Villager) entity).setProfession(Villager.Profession.FARMER);
			}
		}
		return entity;
	}

	public LivingEntity kill() {
		LivingEntity en = entity;
		if (entity != null) {
			Chunk chunk = entity.getLocation().getChunk();
			if (!chunk.isLoaded()) {
				chunk.load();
			}
			entity.remove();
			entity = null;
		}
		return en;
	}

	public LivingEntity getEntity() {
		return entity;
	}

	public EntityType getEntityType() {
		return type;
	}
	
	public void setEntityType(EntityType type) {
		if (type != null && type.isAlive()) {
			this.type = type;
		}
	}

	public Location getStoreLocation() {
		return loc;
	}

	public String getShopFile() {
		return shop;
	}
	
	public String getShopCustomName() {
		return shopName;
	}

	public boolean getUseParent() {
		return useParent && shop != null;
	}
	
	public boolean isShopCustomName() {
		return enableCustomName;
	}

}

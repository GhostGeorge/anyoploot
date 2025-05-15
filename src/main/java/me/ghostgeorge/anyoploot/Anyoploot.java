package me.ghostgeorge.anyoploot;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class Anyoploot extends JavaPlugin implements Listener {
    private String opMob;

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        Bukkit.getConsoleSender().sendRichMessage("<green>OP loot plugin enabled!");
        opMob = getConfig().getString("Op-Mob", "HORSE").toUpperCase();
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        @NotNull LivingEntity entity = event.getEntity();
        try {
            EntityType mobType = EntityType.valueOf(opMob);
            if (entity.getType() == mobType) {
                // Clears drops
                event.getDrops().clear();
                // Logs in console for debugging purposes
                getServer().getLogger().info("Op mob " + opMob + " died");
                // random number for loot table
                double random = Math.random();
                // adds op loot
                // Define loot and their chances
                // Chat gpt generated loot table
                // Rare Loot (Random drops with varying chances)

                // Random chance for Enchanted Diamond Sword (40% chance)
                if (Math.random() < 0.4) {
                    ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
                    ItemMeta swordMeta = diamondSword.getItemMeta();
                    swordMeta.addEnchant(Enchantment.SHARPNESS, 5, true); // Sharpness V
                    swordMeta.addEnchant(Enchantment.FIRE_ASPECT, 2, true); // Fire Aspect II
                    swordMeta.addEnchant(Enchantment.UNBREAKING, 3, true); // Unbreaking III
                    swordMeta.addEnchant(Enchantment.LOOTING, 3, true); // Looting III (high tier)
                    diamondSword.setItemMeta(swordMeta);
                    event.getDrops().add(diamondSword);
                }

                // Random chance for Enchanted Diamond Chestplate (25% chance)
                if (Math.random() < 0.25) {
                    ItemStack chestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                    ItemMeta chestplateMeta = chestplate.getItemMeta();
                    chestplateMeta.addEnchant(Enchantment.PROTECTION, 4, true); // Protection IV
                    chestplateMeta.addEnchant(Enchantment.UNBREAKING, 3, true); // Unbreaking III
                    chestplateMeta.addEnchant(Enchantment.THORNS, 2, true); // Thorns II (to increase its durability)
                    chestplate.setItemMeta(chestplateMeta);
                    event.getDrops().add(chestplate);
                }

                // Random chance for Enchanted Book (30% chance)
                if (Math.random() < 0.3) {
                    ItemStack enchantedBook = new ItemStack(Material.ENCHANTED_BOOK);
                    ItemMeta bookMeta = enchantedBook.getItemMeta();
                    bookMeta.addEnchant(Enchantment.LOOTING, 3, true); // Looting III
                    bookMeta.addEnchant(Enchantment.MENDING, 1, true); // Mending (OP enchant)
                    enchantedBook.setItemMeta(bookMeta);
                    event.getDrops().add(enchantedBook);
                }

                // Ultra-Rare Loot (Super low chance, these should be rare OP drops)

                // Random chance for Netherite Block (20% chance)
                if (Math.random() < 0.2) {
                    event.getDrops().add(new ItemStack(Material.NETHERITE_BLOCK, 1)); // Drop 1 Netherite Block
                }

                // Random chance for Elytra (5% chance) with custom name
                if (Math.random() < 0.05) {
                    ItemStack rareElytra = new ItemStack(Material.ELYTRA);
                    ItemMeta rareItemMeta = rareElytra.getItemMeta();
                    rareItemMeta.setDisplayName("§6Elytra of the Undead King"); // Custom name
                    rareElytra.setItemMeta(rareItemMeta);
                    event.getDrops().add(rareElytra);
                }

                // Super Ultra-Rare Loot (1% chance for the rarest items)

                // Random chance for a custom Nether Star (1% chance)
                if (Math.random() < 0.01) {
                    ItemStack customNetherStar = new ItemStack(Material.NETHER_STAR);
                    ItemMeta starMeta = customNetherStar.getItemMeta();
                    starMeta.setDisplayName("§dCelestial Nether Star"); // Custom name
                    customNetherStar.setItemMeta(starMeta);
                    event.getDrops().add(customNetherStar);
                }

                // Random chance for custom OP armor set (Helmet, Chestplate, Boots - 20% chance)
                if (Math.random() < 0.20) {
                    // Custom Enchanted Helmet
                    ItemStack customHelmet = new ItemStack(Material.DIAMOND_HELMET);
                    ItemMeta helmetMeta = customHelmet.getItemMeta();
                    helmetMeta.addEnchant(Enchantment.PROTECTION, 4, true); // Protection IV
                    helmetMeta.addEnchant(Enchantment.UNBREAKING, 3, true); // Unbreaking III
                    customHelmet.setItemMeta(helmetMeta);
                    event.getDrops().add(customHelmet);

                    // Custom Enchanted Boots
                    ItemStack customBoots = new ItemStack(Material.DIAMOND_BOOTS);
                    ItemMeta bootsMeta = customBoots.getItemMeta();
                    bootsMeta.addEnchant(Enchantment.FEATHER_FALLING, 4, true); // Feather Falling IV
                    bootsMeta.addEnchant(Enchantment.UNBREAKING, 3, true); // Unbreaking III
                    customBoots.setItemMeta(bootsMeta);
                    event.getDrops().add(customBoots);

                    // Custom Enchanted Chestplate (already added earlier but repeating for set)
                    ItemStack customChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                    ItemMeta chestplateSetMeta = customChestplate.getItemMeta();
                    chestplateSetMeta.addEnchant(Enchantment.PROTECTION, 4, true); // Protection IV
                    chestplateSetMeta.addEnchant(Enchantment.UNBREAKING, 3, true); // Unbreaking III
                    customChestplate.setItemMeta(chestplateSetMeta);
                    event.getDrops().add(customChestplate);
                    // end of chatgpt generated code
                }
            }








        } catch (IllegalArgumentException e) {
            getLogger().warning("Invalid mob type in config. Please check the 'Op-Mob' config file.");
        }



    }
}

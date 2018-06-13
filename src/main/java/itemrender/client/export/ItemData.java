package itemrender.client.export;

import itemrender.ItemRenderMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.apache.logging.log4j.Logger;

public class ItemData
{
  private String name;
  private String englishName;
  private String registerName;
  private int metadata;
  private String CreativeTabName;
  private String type;
  private int maxStackSize;
  private int maxDurability;
  private String smallIcon;
  private String largeIcon;
  private transient ItemStack itemStack;
  
  public ItemData(ItemStack itemStack)
  {
    if (ItemRenderMod.debugMode) {
      ItemRenderMod.instance.log.info("Processing " + itemStack.getUnlocalizedName() + "@" + itemStack.getItemDamage());
    }
    this.name = null;
    this.englishName = null;
    this.registerName = itemStack.getItem().getRegistryName().toString();
    metadata=itemStack.getItemDamage();
    this.CreativeTabName = null;
    this.type = ExportUtils.INSTANCE.getType(itemStack);
    this.maxStackSize = itemStack.getMaxStackSize();
    this.maxDurability = (itemStack.getMaxDamage() + 1);
    this.smallIcon = ExportUtils.INSTANCE.getSmallIcon(itemStack);
    this.largeIcon = ExportUtils.INSTANCE.getLargeIcon(itemStack);
    this.itemStack = itemStack;
  }
  
  public ItemStack getItemStack()
  {
    return this.itemStack;
  }
  
  public void setName(String name)
  {
    this.name = name;
  }
  
  public void setEnglishName(String englishName)
  {
    this.englishName = englishName;
  }
  public void setCreativeName(String name) {
      this.CreativeTabName = name;
  }

}

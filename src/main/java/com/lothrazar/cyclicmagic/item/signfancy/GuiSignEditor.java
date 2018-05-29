/*******************************************************************************
 * The MIT License (MIT)
 * 
 * Copyright (C) 2014-2018 Sam Bassett (aka Lothrazar)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.lothrazar.cyclicmagic.item.signfancy;

import java.io.IOException;
import java.util.ArrayList;
import org.lwjgl.input.Keyboard;
import com.lothrazar.cyclicmagic.ModCyclic;
import com.lothrazar.cyclicmagic.core.gui.GuiButtonTooltip;
import com.lothrazar.cyclicmagic.core.util.UtilChat;
import com.lothrazar.cyclicmagic.gui.ITooltipButton;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;// http://www.minecraftforge.net/forum/index.php?topic=22378.0
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiSignEditor extends GuiScreen {

  private static final int rowHeight = 22;
  protected ArrayList<GuiTextField> txtBoxes = new ArrayList<GuiTextField>();
  private final EntityPlayer entityPlayer;
  private ItemStack bookStack;

  final int maxNameLen = 100;
  private TileEntitySign sign;

  public GuiSignEditor(EntityPlayer entityPlayer, ItemStack book, TileEntitySign te) {
    this.entityPlayer = entityPlayer;
    bookStack = book;
    this.sign = te;

  }

  public static int buttonIdNew;
  GuiButton buttonNew;
  //  GuiTextField txtNew;
  final int DELETE_OFFSET = 1000;

  // TODO VALIDATOR https://github.com/Vazkii/Quark/blob/91dac31d768fbeed3ec2f33e16db33731209b8cf/src/main/java/vazkii/quark/client/gui/GuiBetterEditSign.java#L219
  @Override
  public void initGui() {
    Keyboard.enableRepeatEvents(true);
    // great tips here
    // http://www.minecraftforge.net/forum/index.php?topic=29945.0
    if (bookStack.hasTagCompound() == false) {
      bookStack.setTagCompound(new NBTTagCompound());
    }
    int buttonID = 700;
    int w = 100, h = 20, x = 12, y = 20;
    //int buttonID = 0, w = 100, h = 20, ypad = 1, x = 8, y = 20;
    GuiTextField txtNew0 = new GuiTextField(buttonID++, this.fontRenderer, x, y, w, h);
    txtNew0.setMaxStringLength(maxNameLen);
    txtNew0.setFocused(true);
    txtNew0.setText(sign.signText[0].getUnformattedText());
    txtBoxes.add(txtNew0);

    ////////////row 1
    y += rowHeight;
    GuiTextField txtNew1 = new GuiTextField(buttonID++, this.fontRenderer, x, y, w, h);
    txtNew1.setMaxStringLength(maxNameLen);
    txtBoxes.add(txtNew1);
    txtNew1.setText(sign.signText[1].getUnformattedText());
    ////////////row 2
    y += rowHeight;
    GuiTextField txtNew2 = new GuiTextField(buttonID++, this.fontRenderer, x, y, w, h);
    txtNew2.setMaxStringLength(maxNameLen);
    txtNew2.setText(sign.signText[2].getUnformattedText());
    txtBoxes.add(txtNew2);
    ////////////row 3
    y += rowHeight;
    GuiTextField txtNew3 = new GuiTextField(buttonID++, this.fontRenderer, x, y, w, h);
    txtNew3.setMaxStringLength(maxNameLen);
    txtNew3.setText(sign.signText[3].getUnformattedText());
    txtBoxes.add(txtNew3);
    //and the button rows
    addButtonRowForTextbox(0, 24);
    addButtonRowForTextbox(1, 46);
    addButtonRowForTextbox(2, 68);
    addButtonRowForTextbox(3, 90);
    ///////////
    GuiButtonTooltip buttonSave = new GuiButtonTooltip(800, this.width / 4 + w / 2, 150, w, h, "gui.signs.save");

    this.addButton(buttonSave);

  }

  private void addButtonRowForTextbox(int signRowNum, int height) {
    int buttonID = signRowNum * 100;
    int w, h, x = 104, y = height, numchar = 0;
    w = h = 14;

    for (TextFormatting color : TextFormatting.values()) {
      if (color.isColor()) {
        GuiButtonTooltip btn = new GuiButtonTooltip(buttonID++, x + 40, y, w, h,
            //Integer.toHexString(numchar).toUpperCase()
            getColorChar(color));

        btn.setTooltip(color + color.getFriendlyName());
        btn.packedFGColour = toHex(color);
        this.addButton(btn);
        numchar++;
        x += w - 1;

      }
    }
    x += w * 3 + 2;
    y = height;

    for (TextFormatting color : TextFormatting.values()) {
      if (!color.isColor() && color != TextFormatting.RESET) {
        GuiButtonTooltip btn = new GuiButtonTooltip(buttonID++, x, y, w, h,
            getFontChar(color));
        btn.setTooltip(color + color.getFriendlyName());
        this.addButton(btn);
        x += w;
      }
    }
  }

  public static String getColorChar(TextFormatting color) {
    if (color == null) {
      return "";
    }
    return color + Integer.toHexString(color.ordinal()).toUpperCase();
  }

  public static String getFontChar(TextFormatting color) {
    if (color == null) {
      return "";
    }
    return color + color.getFriendlyName().substring(0, 1);
  }

  /**
   * https://minecraft.gamepedia.com/Formatting_codes
   * 
   * TODO: static util
   * 
   * @param color
   * @return
   */
  @SuppressWarnings("unused")
  public static int toHex(TextFormatting color) {
    switch (color) {
      case BLACK://0
        return 0x010101;//should be all 0, but that gets ignored and reset to white
      case DARK_BLUE://1
        return 0x0000AA;
      case DARK_GREEN://2
        return 0x00AA00;
      case DARK_AQUA://3
        return 0x00AAAA;
      case DARK_RED://4
        return 0xAA0000;
      case DARK_PURPLE://5
        return 0xAA00AA;
      case GOLD://6
        return 0xFFAA00;
      case GRAY://7
        return 0xAAAAAA;
      case DARK_GRAY://8
        return 0x555555;
      case BLUE://9
        return 0x5555FF;
      case GREEN://A
        return 0x55FF55;
      case AQUA://B
        return 0x55FFFF;
      case RED://C
        return 0xFF5555;
      case LIGHT_PURPLE://D
        return 0xFF55FF;
      case YELLOW://E
        return 0xFFFF55;
      case WHITE:
        return 0xFFFFFF;
      default:
        return -1;
    }
  }

  @Override
  public void onGuiClosed() {
    Keyboard.enableRepeatEvents(false);
  }


  @Override
  public void drawScreen(int x, int y, float par3) {

    drawDefaultBackground();
    super.drawScreen(x, y, par3);
    drawCenteredString(fontRenderer, UtilChat.lang("gui.signs.title"), width / 2, 6, 16777215);
    // http://www.minecraftforge.net/forum/index.php?topic=22378.0
    // no idea why this is sometimes randomly null and only on world start if i
    // open it too quick??

 
    for (GuiTextField txtNew : txtBoxes) {
      int key = txtNew.getId() - 700;
      int ytxt = 28 + key * 20;
      //      TextFormatting color = this.colors[key];
      //      TextFormatting font = this.fonts[key];
      //      drawCenteredString(fontRenderer, getColorChar(color), 124, ytxt, 16777215);
      //      drawCenteredString(fontRenderer, getFontChar(font), 138, ytxt, 16777215);
      if (txtNew != null) {
        txtNew.drawTextBox();
      }
    }
    for (int i = 0; i < buttonList.size(); i++) {
      if (buttonList.get(i).isMouseOver() && buttonList.get(i) instanceof ITooltipButton) {
        ITooltipButton btn = (ITooltipButton) buttonList.get(i);
        drawHoveringText(btn.getTooltips(), x, y, fontRenderer);
      }
    }
  }

  @SuppressWarnings("incomplete-switch")
  @Override
  protected void actionPerformed(GuiButton btn) {
    if (btn.id == 800) {

      ModCyclic.logger.log("SAVE TODO ");
      //TODO: save on server also 
      return;
    }
    int row = btn.id / 100;
    int col = btn.id % 100;
    Style style = this.sign.signText[row].getStyle();

    if (col <= 15) {

      style.setColor(TextFormatting.values()[col]);

    }
    else {
      //convert to the truefalse
      TextFormatting font = TextFormatting.values()[col];
      switch (font) {
        case BOLD:
          style.setBold(!style.getBold());
        break;
        case OBFUSCATED:
          style.setObfuscated(!style.getObfuscated());
        break;
        case STRIKETHROUGH:
          style.setStrikethrough(!style.getStrikethrough());
        break;
        case UNDERLINE:
          style.setUnderlined(!style.getUnderlined());
        break;
        case ITALIC:
          style.setItalic(!style.getItalic());
        break;
      }
    }
    this.sign.signText[row].setStyle(style);
    //colors are 0-15, fonts are  16-20 

    //    if (btn.id == buttonIdNew) {
    //      ModCyclic.network.sendToServer(new PacketNewButton(txtNew.getText()));
    //    }
    //    else if (btn instanceof ButtonWaypointDelete) {
    //      ModCyclic.network.sendToServer(new PacketDeleteWaypoint(((ButtonWaypointDelete) btn).getSlot()));
    //    }
    //    else if (btn instanceof ButtonWaypointTeleport) {
    //      // moved to btn class
    //    }
    //    this.entityPlayer.closeScreen();
  }

  @Override
  public boolean doesGuiPauseGame() {
    return false;
  }

  // http://www.minecraftforge.net/forum/index.php?topic=22378.0
  // below is all the stuff that makes the text box NOT broken
  @Override
  public void updateScreen() {
    super.updateScreen();
    for (GuiTextField txtNew : txtBoxes)
      if (txtNew != null) {
        txtNew.updateCursorCounter();
      }
  }

  @Override
  protected void keyTyped(char par1, int par2) throws IOException {
    super.keyTyped(par1, par2);
    for (GuiTextField txtNew : txtBoxes)
      if (txtNew != null) {
        txtNew.textboxKeyTyped(par1, par2);
      }
  }

  @Override
  protected void mouseClicked(int x, int y, int btn) throws IOException {
    super.mouseClicked(x, y, btn);
    for (GuiTextField txtNew : txtBoxes)
      if (txtNew != null) {
        txtNew.mouseClicked(x, y, btn);
      }
  }
  // ok end of textbox fixing stuff
}

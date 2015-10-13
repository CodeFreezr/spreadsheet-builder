package org.modelcatalogue.builder.spreadsheet.poi

import org.apache.poi.ss.usermodel.FontUnderline
import org.apache.poi.xssf.usermodel.XSSFCellStyle
import org.apache.poi.xssf.usermodel.XSSFFont
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.modelcatalogue.builder.spreadsheet.api.Color
import org.modelcatalogue.builder.spreadsheet.api.Font

class PoiFont implements Font {

    private final XSSFFont font

    PoiFont(XSSFWorkbook workbook, XSSFCellStyle style) {
        font = workbook.createFont()
        style.font = font
    }

    @Override
    void color(String hexColor) {
        font.setColor(PoiCellStyle.parseColor(hexColor))
    }

    @Override
    void color(Color colorPreset) {
        color colorPreset.hex
    }

    @Override
    void size(int size) {
        font.fontHeightInPoints = (short) size
    }

    @Override
    Object getItalic() {
        font.italic = true
    }

    @Override
    Object getBold() {
        font.bold = true
    }

    @Override
    Object getStrikeout() {
        font.strikeout = true
    }

    @Override
    Object getUnderline() {
        // TODO: support all variants
        font.setUnderline(FontUnderline.SINGLE)
        return null
    }
}

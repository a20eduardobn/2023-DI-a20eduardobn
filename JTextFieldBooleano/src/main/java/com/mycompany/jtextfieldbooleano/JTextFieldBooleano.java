/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jtextfieldbooleano;

import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author a20eduardobn
 */
public class JTextFieldBooleano extends JTextField {

    private boolean numbersOnly;

    public JTextFieldBooleano() {
    }

    public boolean isNumbersOnly() {
        return numbersOnly;
    }

    public void setNumbersOnly(boolean numbersOnly) {
        this.numbersOnly = numbersOnly;
        changeAlphanumericStatus();
    }

    private void changeAlphanumericStatus() {
        AbstractDocument document = (AbstractDocument) getDocument();
        document.setDocumentFilter(numbersOnly ? createNumbersOnlyFilter() : null);
    }

    private DocumentFilter createNumbersOnlyFilter() {
        return new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                if (containsOnlyNumbers(text)) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attr) throws BadLocationException {
                if (containsOnlyNumbers(text)) {
                    super.replace(fb, offset, length, text, attr);
                }
            }

            private boolean containsOnlyNumbers(String text) {
                return text.matches("\\d*");
            }
        };
    }
}

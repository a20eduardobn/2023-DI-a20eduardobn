/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jlabelreloxo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author a20eduardobn
 */
public class JLabelReloxo extends JLabel {

    private boolean formato12H;
    private String horaAlarma;
    private AlarmListener alarmListener;
    private boolean alarmExpired;

    public JLabelReloxo() {
        Timer updateTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                if (formato12H) {
                    formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
                }
                String formattedDateTime = LocalDateTime.now().format(formatter);
                JLabelReloxo.this.setText(formattedDateTime);
            }
        });
        updateTimer.start();

        Timer alarmTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                String horaActual = LocalDateTime.now().format(formatter);
                if (horaActual.equals(horaAlarma)) {
                    if (JLabelReloxo.this.alarmListener != null) {
                        if (!alarmExpired) {
                            JLabelReloxo.this.alarmListener.alarmTriggered();
                            alarmExpired = true;
                        }
                    }
                }
            }
        });
        alarmTimer.start();
    }

    public boolean isFormato12H() {
        return formato12H;
    }

    public void setFormato12H(boolean formato12H) {
        this.formato12H = formato12H;
    }

    public String getHoraAlarma() {
        return horaAlarma;
    }

    public void setHoraAlarma(String horaAlarma) {
        this.horaAlarma = horaAlarma;
    }

    public void setAlarmListener(AlarmListener alarmListener) {
        this.alarmListener = alarmListener;
    }

}



package com.mycompany.semaforo2.newpackage;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class Semaforo extends JFrame{
    JLabel Peaton= new JLabel();
    JLabel trafico;
    JLabel time;
    JLabel Semaforo=new JLabel();
    JPanel panel = new JPanel(); // creacion panel 
    JSlider desliza;
    Timer timer;
    Timer timer1;
    Timer timer2;
    Timer timer3;
    Timer timer4;
    TimerTask timertask;
    TimerTask timertask1;
    public int i=5,n=20,m=25,t, t1=m,t2=n, x;
    public boolean v=false,v1=false;
    public Semaforo(){
        this.setSize(1000,800);//tamaño
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("SEMAFORO");//titulo
        setLocationRelativeTo(null);//establecemos la ventana en el centro de la pantalla
        initcomponents();
        colocarSlide();
        MostrarTiempo();
    }
    
    private void initcomponents(){
        panel.setLayout(null);
        this.getContentPane().add(panel); // agregar panel a ventana
        Peaton.setBounds(150, 500, 100, 200);
        panel.add(Peaton);
        
        Semaforo.setBounds(100,10,270,500);
        panel.add(Semaforo);
        
        colocarBotones();
        
        trafico = new JLabel("TRAFICO: ");
        trafico.setBounds(500,100,100, 100);
        panel.add(trafico);
    }
    private void MostrarTiempo(){
      time = new JLabel();
      time.setBounds(500, 300, 300, 100);
      
      panel.add(time);
    }
    
    private void colocarSlide(){
        desliza = new JSlider();
        desliza.setPaintTicks(true);
        desliza.setPaintLabels(true);
        desliza.setValue(0);
        desliza.setMajorTickSpacing(10);
        desliza.setBounds(500,170,300,100);
        Component add = panel.add(desliza);
        ChangeListener Oyente = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent arg0) {
            trafico.setText("TRAFICO: " +desliza.getValue());
            x=desliza.getValue(); 
            if(v==true)
               {
                   n=25;
                   m=20;
               }
               else
               {
                   n=20;
                   m=20;
               }
               
               if(x>0)
               {
                   for(int p=0;p<x;p=p+10)
                   {
                       m++;
                       n--;
                   }
                   
               }
            }
            
            };
        desliza.addChangeListener(Oyente);
        
    }
    private void colocarBotones(){
        JButton PrioridadPeatonal = new JButton("PRIORIDAD PEATONAL");
        
        PrioridadPeatonal.setBounds(500,500,300,100);
        panel.add(PrioridadPeatonal);
        
        ActionListener l = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(!v){
                    PrioridadPeatonal.setText("DETENER PRIORIDAD PEATONAL");
                    v=true;
                    n+=5;
                    
                    
                }
                else{
                    v=false;
                    PrioridadPeatonal.setText("PRIORIDAD PEATONAL");
                }
            }
        };
        PrioridadPeatonal.addActionListener(l);
        
        /*JButton BotonTra = new JButton("SELECCIONAR TRAFICO");
        BotonTra.setBounds(600,130,210,40);
        panel.add(BotonTra);
        ActionListener s= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               
            }
            
            
        };
        BotonTra.addActionListener(s);
       */ 
    }
        public void Peaton1 (){
        
             timer = new Timer();
             timertask = new TimerTask() {
             @Override
             public void run() {
             i++;
             if(i==5 ){
             Peaton.setIcon(new ImageIcon("contact1.jpg"));
              }
             if(i==7 ){
 
              Peaton.setIcon(new ImageIcon("recoil1.jpg")); 
              }
     
             if( i==9  ){

             Peaton.setIcon(new ImageIcon("passing1.jpg")); 
             }
             if( i==11  ){
              Peaton.setIcon(new ImageIcon("Highpoint1.jpg")); 
              i=5;
              }
              }
              };
              timer.scheduleAtFixedRate(timertask, 0, 100);//cada 100ms se 
        }
        
        
        public void ROJO(int j,int m){
             class Recordatorio extends TimerTask {
         @Override
          public void run() {  
          timer4.cancel();
          mostrarTiempoAmarillo();
          Semaforo.setIcon(new ImageIcon("semaforo amarillo.jpg"));
          timer.cancel();
            verdecito();
         timer1.cancel(); //Termina el hilo del timer
 }
 }
            timer1 = new Timer();
         timer1.schedule(new Recordatorio(),j*1000);//Programa la tarea
        
        }
        
         public void Amarillo(int j,int n,int m){
             class verde extends TimerTask {
         @Override
          public void run() {
          timer4.cancel();
          mostrarTiempoVerde();
          Semaforo.setIcon(new ImageIcon("semaforo verde.jpg"));
          Amarillo1(m,n,m);
         timer2.cancel(); //Termina el hilo del timer
 }
 }
            timer2 = new Timer();
         timer2.schedule(new verde(),j*1000);//Programa la tarea
        
        }
        public void verde(int j,int n,int m){
             class Recordatorio extends TimerTask {
         @Override
          public void run() {
         timer4.cancel();
          mostrarTiempoRojo();
         Semaforo.setIcon(new ImageIcon("semaforo rojo.jpg"));
            Peaton1();
            ROJO(n,m);
         timer3.cancel(); //Termina el hilo del timer
 }
 }
            timer3 = new Timer();
         timer3.schedule(new Recordatorio(),j*1000);//Programa la tarea
        
        }
          public void Amarillo1(int j,int n,int m){
             class verde1 extends TimerTask {
         @Override
          public void run() {
          timer4.cancel();
          mostrarTiempoAmarillo();
          Semaforo.setIcon(new ImageIcon("semaforo amarillo.jpg"));
          rojito();
         timer1.cancel(); //Termina el hilo del timer
 }
 }
            timer1 = new Timer();
         timer1.schedule(new verde1(),j*1000);//Programa la tarea
        
        }
          
          public void rojito(){
              
              
              verde(3,n,m);
          }
          public void verdecito(){
              Amarillo(3,n,m);
          }
          public void mostrarTiempoRojo()
          { 
              t2=n;
              timer4 = new Timer();
             timertask1 = new TimerTask() {
             @Override
             public void run() {
                time.setText("Faltan : "+ t2 + " segundos");
                t2--;
             
             }
              };
              timer4.scheduleAtFixedRate(timertask1, 0, 1000);
              }
public void mostrarTiempoVerde()
          {     
              t1=m;
              timer4 = new Timer();
             timertask1 = new TimerTask() {
             @Override
             public void run() {
                 time.setText("Faltan : "+ t1 + " segundos");
                t1--;
             }
              };
              timer4.scheduleAtFixedRate(timertask1, 0, 1000);
              }
public void mostrarTiempoAmarillo()
          {
              t=3;
              timer4 = new Timer();
             timertask1 = new TimerTask() {
             @Override
             public void run() {
                 time.setText("Faltan : "+ t + " segundos");
                t--;
             }
              };
              timer4.scheduleAtFixedRate(timertask1, 0, 1000);
              }
}


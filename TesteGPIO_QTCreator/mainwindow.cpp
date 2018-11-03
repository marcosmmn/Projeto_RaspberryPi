#include "mainwindow.h"
#include "ui_mainwindow.h"
#include <QKeyEvent>
#define BOTON 0



MainWindow::MainWindow(QWidget *parent) :
    QMainWindow(parent),
    ui(new Ui::MainWindow)

    {
        ui->setupUi(this);
        wiringPiSetup();
        pinMode(8,OUTPUT);


        pinMode(2,INPUT);
        pinMode(7,INPUT);
        pinMode(3,INPUT);
        pinMode(0,INPUT);
        pinMode(6,INPUT);
        pinMode(5,INPUT);


        QTimer *timer= new QTimer(this);
        connect (timer,SIGNAL(timeout()),this,SLOT(update()));
                timer->start(100);

    }


MainWindow::~MainWindow()
{
    delete ui;


}

void MainWindow::on_b1_clicked()
{
    digitalWrite(8,HIGH);
}

void MainWindow::on_b2_clicked()
{
    digitalWrite(8,LOW);
}

void MainWindow::on_MainWindow_iconSizeChanged(const QSize &iconSize)
{

}

void MainWindow::update(){



    if(digitalRead(2)==HIGH){

        ui->esq->setText("Não Pressionada");
        ui->ledesq->setStyleSheet("Color:black; font-size:24pt;");
    }else{

       ui->esq->setText("Pressionada");
       ui->ledesq->setStyleSheet("Color:red; font-size:24pt;");
    }
    if(digitalRead(7)==HIGH){
        ui->cima->setText("Não Pressionada");
        ui->ledcima->setStyleSheet("Color:black; font-size:24pt;");
    }else{
       ui->cima->setText("Pressionada");
       ui->ledcima->setStyleSheet("Color:red; font-size:24pt;");
    }

    if(digitalRead(3)==HIGH){
        ui->dir->setText("Não Pressionada");
        ui->leddir->setStyleSheet("Color:black; font-size:24pt;");
    }else{
       ui->dir->setText("Pressionada");
       ui->leddir->setStyleSheet("Color:red; font-size:24pt;");
    }
    if(digitalRead(0)==HIGH){
        ui->baixo->setText("Não Pressionada");
        ui->ledbaixo->setStyleSheet("Color:black; font-size:24pt;");
    }else{
       ui->baixo->setText("Pressionada");
       ui->ledbaixo->setStyleSheet("Color:red; font-size:24pt;");
    }
    if(digitalRead(6)==HIGH){
        ui->btna->setText("Não Pressionada");
        ui->leda->setStyleSheet("Color:black; font-size:24pt; font-weight:bold;");
    }else{
       ui->btna->setText("Pressionada");
       ui->leda->setStyleSheet("Color:red; font-size:24pt; font-weight:bold;");
    }
    if(digitalRead(5)==HIGH){
        ui->btnb->setText("Não Pressionada");
        ui->ledb->setStyleSheet("Color:black; font-size:24pt; font-weight:bold;");
    }else{
       ui->btnb->setText("Pressionada");
       ui->ledb->setStyleSheet("Color:red; font-size:24pt; font-weight:bold;");
    }
}

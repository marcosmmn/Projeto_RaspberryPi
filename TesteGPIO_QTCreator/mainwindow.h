#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include "wiringPi.h"
#include "QTimer"

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();




private slots:
    void on_b1_clicked();

    void on_b2_clicked();

    void on_MainWindow_iconSizeChanged(const QSize &iconSize);

    void update();

private:
    Ui::MainWindow *ui;
};

#endif // MAINWINDOW_H

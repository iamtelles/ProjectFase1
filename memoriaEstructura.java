package proyecto1sopes1;
import java.util.ArrayList;


public class memoriaEstructura {
    
    //uso = memoria en uso
    private int uso = 0;
    //tamaño es el del proceso
    private int tamano = 8192000;//kb
    //tiempo para uso de la cpu
    private int timerterminarproceso;
    //tamaño total de memoria disponible para uso
    private int disponible = tamano;
    //identificacion de usuario
    private int UID;

    //LOGICA DE PROCESOS INTERNOS (Array de objetos proceso)
    public ArrayList<proceso> procesosInternos = new ArrayList();

    public StringBuilder getListaProcesosInternos() {
        
        StringBuilder lista = new StringBuilder();
        /* StringBuilder() clases que permiten crear objetos que almacenan cadenas 
        de caracteres que pueden ser modificadas sin necesidad de crear nuevos
        objetos*/
        for (int i = 0; i < this.procesosInternos.size(); i++) {
            //recorremos el array
            lista.append(this.procesosInternos.get(i).getNombre() + " ");
            //Edgar ya corregi la lista que se muestra de procesos
        }
        return lista;//regresamos la lista con todos los procesos
    }

    public void agregarProcesoAMemoria(proceso procesoNuevo) {
        procesosInternos.add(procesoNuevo);
        //agregamos un proceso con el add que nos da Java
    }

    public void eliminarProceso(int uid) {
        //buscamos el proceso dentro del array
        for (int i = 0; i < this.procesosInternos.size(); i++) {
            if (uid == procesosInternos.get(i).getUID()) {
                //al encontrarlo sumamos la memoria al inicial y procedemos a eliminarlo de la lista
                disponible = disponible + procesosInternos.get(i).getMemoria();
                procesosInternos.remove(i);
            }
        }
    }

    public void setearUltimaMemoria() {
        //del array aca ya tomamos el tamaño y la memoria total disponible
        this.procesosInternos.get(procesosInternos.size() - 1).setMemoria(8192000);
    }

    public int obtenerUIDPrimerProceso() {
        try {
            //UID del proceso
            return procesosInternos.get(0).getUID();
        } catch (Exception e) {
            return -1;
        }
    }

    //getters y setters
    public int getTimerterminarproceso() {
        return timerterminarproceso;
    }

    memoriaEstructura() {
        int min = 2;
        int max = 3;
        timerterminarproceso = (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public int getUID() {
        return UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public void disminuirTimer() {
        this.timerterminarproceso--;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public int getUso() {
        uso = 0;
        for (int i = 0; i < this.procesosInternos.size(); i++) {
            uso = uso + this.procesosInternos.get(i).getMemoria();
        }
        return uso;
    }

    public int getDisponible() {
        disponible = 200000;
        for (int i = 0; i < this.procesosInternos.size(); i++) {
            disponible = disponible - this.procesosInternos.get(i).getMemoria();
        }
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

}

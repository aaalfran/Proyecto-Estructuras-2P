
package TDAs;

import TDAs.List;

public class LinkedList<E> implements List<E> {
     private NodeList<E> first;
    private NodeList<E> last;

    public LinkedList() {
        first = null;
        last = null;
    }

    @Override
    public boolean addFirst(E e) {
        NodeList<E> Nn = new NodeList<>(e);
        if (isEmpty()) {
            first = Nn;
            last = Nn;
        } else {
            Nn.setNext(first);
            first = Nn;
        }
        return true;
    }

    @Override
    public boolean addLast(E e) {
        
         NodeList<E> Nn = new NodeList<>(e);
        if (isEmpty()) {
            first = Nn;
            last =Nn ;
        } else {
            last.setNext(Nn);
            last = Nn;
        }
        return true;
    }

    @Override
    public E removeFirst() {
         if (isEmpty()) {
            return null;
        } else {
             E contenidoAnterior= first.getContent();
            first = first.getNext();
            return contenidoAnterior;
        }
    }

    @Override
    public E removeLast() {
        if(isEmpty()){
            return null;
        }
        NodeList<E> penultimo= null;
         E contenidoNterior= last.getContent();
        for (NodeList<E> p = first; p.getNext() != null; p = p.getNext()) {
            penultimo = p;
        }
        
        last = penultimo;
        last.setNext(null);
     
        return contenidoNterior;
       
    }

    @Override
    public int size() {
          int acum = 0;
        for (NodeList<E> Nn = first; Nn != null; Nn= Nn.getNext()) {
            acum++;
        }

        return acum;
    }

    @Override
    public boolean isEmpty() {
        return first == null && last == null;
    }

    @Override
    public void clear() {
   
        if(size()>0){
         first.setNext(null);
         last.setNext(null);
            
        }
    }
    public String toString(){
       String s="";
       NodeList<E>n;
       //ITERACIÖN
       for(n=this.first;n!=null;n=n.getNext()){
           E e=n.getContent();
           s+= e.toString()+" ";
       }
       return s;
    }
    
}

   
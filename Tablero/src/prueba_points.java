import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class prueba_points {

	
	private static List<List<Point>> rutas = new ArrayList<List<Point>>();
	private static List<Point> lstBloqued = null; 
	
	
	public static void main(String[] args) {
    
		Point p1 = new Point(0,0);
		Point p2 = new Point(1,2);
		
		//int a = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
		//System.out.println(a);
		
		List<Point> l = new ArrayList<Point>();
		
		/*
		BestWay(p1,p2,1000);
		for(List<Point> lst : rutas) {
			System.out.println("***************" + System.getProperty("line.separator"));
			for(Point p : lst) {
				System.out.println(p.toString());
			}			
			System.out.println("***************" + System.getProperty("line.separator"));
		}
		*/
		
		
		//En teor�a pilla el primer camino que encuentra
		/*
		firstBestWay(p1, p2, 1000, l );
				
		for(Point p : l){
			System.out.println(p.toString());
		}
		*/
		
		
		//BestWay2(p1, p2, getDistance(p1, p2));
		//BestWay3(p1, p2, getDistance(p1, p2), null);
		
		/*
		for(List<Point> lst : rutas) {
			System.out.println("***************" + System.getProperty("line.separator"));
			for(Point p : lst) {
				System.out.println(p.toString());
			}			
			System.out.println("***************" + System.getProperty("line.separator"));
		}
		*/
		
		/*
		BestWay4(p1, p2, getDistance(p1, p2), null);
		
				
				for(List<Point> lst : rutas) {
					System.out.println("***************" + System.getProperty("line.separator"));
					for(Point p : lst) {
						System.out.println(p.toString());
					}			
					System.out.println("***************" + System.getProperty("line.separator"));
				}
				
		*/
		
		//BestWay5(p1,p2, getDistance(p1,p2), null);
		
		lstBloqued = new ArrayList<Point>();
		//lstBloqued.add(new Point(1,2));
		//lstBloqued.add(new Point(2,2));
		
		lstBloqued.add(new Point(0,1));
		lstBloqued.add(new Point(1,1));
		lstBloqued.add(new Point(2,1));
		
		boolean rutaEncontrada = false;
		int distancia = 0;
		int i = 0;
		
		do {
		
			distancia = getDistance(p1,p2) + i;			
			
			if(BestWay6(p1,p2, distancia, null)) {
				rutaEncontrada = true;
			} else {
				i++;
			}
		
		}while(rutaEncontrada == false);
		
		
		System.out.println("***************" + System.getProperty("line.separator"));
		System.out.println("Rutas cortas posibles:" + rutas.size());
		
		for(List<Point> lst : rutas) {
			System.out.println("***************" + System.getProperty("line.separator"));
			System.out.println("Casillas utilizadas: " + lst.size() + System.getProperty("line.separator"));
			for(Point p : lst) {
				System.out.println(p.toString());
			}			
			System.out.println("***************" + System.getProperty("line.separator"));
		}
    }
	
	public static boolean isBloqued(Point[] bloqued, Point p) {		
		return inArrayPoint(bloqued, p);		
	}
	
	public static boolean inArrayPoint(Point[] arr, Point targetValue) {
		//Busca en el array si existe el objeto pasado 
		for (Point s : arr) {
			if (s.equals(targetValue))
				return true;
		}
		return false;
	}
	
	private static void BestWay6comp(Point adjacent, Point b, List<Point> p, int minDistance) {
		
		//obtenemos la distancia
		int distance = getDistance(adjacent, b);
		
		//Realizamos las comprobaciones
		if(distance == 0) {
			//asumimos que es el destino, este nunca tendría que ser un cuadro bloqueado
			p.add(adjacent);
			//Añadimos la ruta a la lista de rutas			
			rutas.add(p);
			//Eliminamos la lista (termina el ciclo)
			p = null;
		//restricciones a la distancia más corta
		} else if(distance < minDistance){
						
			//otras restricciones, 
			Boolean casillaValida = true;
			
			
			//la adjacente tiene que estar en el tablero (hardcodeado)
			if(adjacent.y > 3 || adjacent.y < 0 ) {
				casillaValida = false;
			}
			
			if(adjacent.x > 3 || adjacent.x < 0 ) {
				casillaValida = false;
			}
			
			
			//la casilla adjacente no puede estar bloqueada
			if(isBloqued(lstBloqued.toArray(new Point[lstBloqued.size()]), adjacent)) {
				casillaValida = false;
			}					
					
			
			//la casilla adyacente tiene que estar a menos distancia que la anterior
			
			if(casillaValida) {
				List<Point> p2 = null;
				
				//clonamos el array pasado, es una nueva rama
				p2 = new ArrayList<Point>(p);
				
				//le añadimos la coordenada encontrada
				p2.add(adjacent);
				
				//progresamos en la rama
				BestWay6(adjacent, b, distance, p2);
			}
		} 
	}
	
	private static boolean BestWay6(Point a, Point b, int minDistance,
			List<Point> p) {
		
		//instanciamos el array de rutas
		if (rutas == null) {
			rutas = new ArrayList<List<Point>>();
		}
		
		//si la lista temporal es null, la creamos y añadimos el primer paso
		if(p == null) {
			p = new ArrayList<Point>();
			p.add(a);
		}

		int distance = 0;
		Point adjacent = null;

		for (int i = 0; i < 4; i++) {
			switch (i) {
			case 0:
				//obtenemos la casilla adjacente
				adjacent = getPointUp(a);
				//Seguimos la rama
				BestWay6comp(adjacent, b, p, minDistance);
				break;
			case 1:
				adjacent = getPointDown(a);
				//Seguimos la rama
				BestWay6comp(adjacent, b, p, minDistance);
				break;

			case 2:
				adjacent = getPointLeft(a);
				//Seguimos la rama
				BestWay6comp(adjacent, b, p, minDistance);
				break;

			case 3:				
				adjacent = getPointRight(a);
				//Seguimos la rama
				BestWay6comp(adjacent, b, p, minDistance);
				break;
			default:
				break;
			}	
		}		
		
		System.out.println("Terminado el ciclo, rutas encontradas: " + rutas.size());	
		
		if(rutas.size() == 0) {
			return false;
		} else {
			return true;
		}
	}
	

	
	
	
	
	
	
	
	
	
	private static void BestWay5(Point a, Point b, int minDistance,
			List<Point> p) {
		
		if (rutas == null) {
			rutas = new ArrayList<List<Point>>();
		}
		
		if(p == null) {
			p = new ArrayList<Point>();
			p.add(a);
		}

		int distance = 0;
		Point adjacent = null;

		for (int i = 0; i < 4; i++) {

			
			
			switch (i) {
			case 0:

				adjacent = getPointUp(a);
				distance = getDistance(adjacent, b);
				
					
				if(distance == 0) {
					p.add(adjacent);
					rutas.add(p);
					p = null;
				} else 	if(distance < minDistance){
					List<Point> p2 = null;
					
					
					p2 = new ArrayList<Point>(p);
					
					
					p2.add(adjacent);
					
					BestWay5(adjacent, b, distance, p2);
									
				} 
				

				break;
			case 1:
				adjacent = getPointDown(a);
				distance = getDistance(adjacent, b);

				if(distance == 0) {
					p.add(adjacent);
					rutas.add(p);
					p = null;
				} else 	if(distance < minDistance){
					List<Point> p2 = null;
					
					
					p2 = new ArrayList<Point>(p);
					
					
					p2.add(adjacent);
					
					BestWay5(adjacent, b, distance, p2);
									
				}  
			

				break;

			case 2:
				adjacent = getPointLeft(a);
				distance = getDistance(adjacent, b);

				if(distance == 0) {
					p.add(adjacent);
					rutas.add(p);
					p = null;
				} else 	if(distance < minDistance){
					List<Point> p2 = null;
					
					
					p2 = new ArrayList<Point>(p);
					
					
					p2.add(adjacent);
					
					BestWay5(adjacent, b, distance, p2);
									
				} 
				
				
				break;

			case 3:
				
				adjacent = getPointRight(a);
				distance = getDistance(adjacent, b);
				
				

				if(distance == 0) {
					p.add(adjacent);
					rutas.add(p);
					p = null;
				} else 	if(distance < minDistance){
					List<Point> p2 = null;
					
					
					p2 = new ArrayList<Point>(p);
					
					
					p2.add(adjacent);
					
					BestWay5(adjacent, b, distance, p2);
									
				} 
				

				break;

			default:
				break;
			}
			
			
		
			
		}		
		//System.out.println("Terminado el ciclo");		
	}

	private static void BestWay4(Point a, Point b, int minDistance,
			List<Point> p) {
		if (rutas == null) {
			rutas = new ArrayList<List<Point>>();
		}

		int distance = 0;
		Point adjacent = null;

		for (int i = 0; i < 4; i++) {

			if (p == null) {
				p = new ArrayList<Point>();
				p.add(a);
			}
			
			switch (i) {
			case 0:

				adjacent = getPointUp(a);
				distance = getDistance(adjacent, b);

				if (distance == 0) { //linea completada
										
					p.add(adjacent);
					rutas.add(p);
					
				}else if (distance < minDistance) {
					p.add(adjacent);
					System.out.print("Right: " + adjacent.toString() + " -> "
							+ distance + System.getProperty("line.separator"));
					BestWay4(adjacent, b, distance, p);				
				} else {
					System.out.println("Ruta abortada con: "
							+ adjacent.toString() + " con distancia "
							+ distance + " y min distancia " + minDistance);
					//p = null;
				}

				break;
			case 1:
				adjacent = getPointDown(a);
				distance = getDistance(adjacent, b);

				if (distance == 0) { //linea completada
					//clonamos el listado y lo a�adimos al listado de listados
									
					p.add(adjacent);
					rutas.add(p);
					
				}else if (distance < minDistance) {
					p.add(adjacent);
					System.out.print("Right: " + adjacent.toString() + " -> "
							+ distance + System.getProperty("line.separator"));
					BestWay4(adjacent, b, distance, p);				
				} else {
					System.out.println("Ruta abortada con: "
							+ adjacent.toString() + " con distancia "
							+ distance + " y min distancia " + minDistance);
					//p = null;
				}

				break;

			case 2:
				adjacent = getPointLeft(a);
				distance = getDistance(adjacent, b);

				if (distance == 0) { //linea completada
										
					p.add(adjacent);
					rutas.add(p);
					
				}else if (distance < minDistance) {
					p.add(adjacent);
					System.out.print("Right: " + adjacent.toString() + " -> "
							+ distance + System.getProperty("line.separator"));
					BestWay4(adjacent, b, distance, p);				
				} else {
					System.out.println("Ruta abortada con: "
							+ adjacent.toString() + " con distancia "
							+ distance + " y min distancia " + minDistance);
					//p = null;
				}
				
				break;

			case 3:
				
				adjacent = getPointRight(a);
				distance = getDistance(adjacent, b);

				if (distance == 0) { //linea completada
					
										
					p.add(adjacent);
					rutas.add(p);
					
				}else if (distance < minDistance) {
					p.add(adjacent);
					System.out.print("Right: " + adjacent.toString() + " -> "
							+ distance + System.getProperty("line.separator"));
					BestWay4(adjacent, b, distance, p);				
				} else {
					System.out.println("Ruta abortada con: "
							+ adjacent.toString() + " con distancia "
							+ distance + " y min distancia " + minDistance);
					//p = null;
				}

				break;

			default:
				break;
			}
			
			
		
			
		}
		
		System.out.println("Terminado el ciclo");
		
	}
	
	
	private static void BestWay3(Point a, Point b, int minDistance,
			List<Point> p) {
		if (rutas == null) {
			rutas = new ArrayList<List<Point>>();
		}

		int distance = 0;
		Point adjacent = null;

		for (int i = 0; i < 4; i++) {

			switch (i) {
			case 0:

				adjacent = getPointUp(a);
				distance = getDistance(adjacent, b);

				if (p == null) {
					p = new ArrayList<Point>();
					p.add(a);
				}

				if (distance < minDistance) {
					p.add(adjacent);
					System.out.print("up: " + adjacent.toString() + " -> "
							+ distance + System.getProperty("line.separator"));
					BestWay3(adjacent, b, distance, p);
				} else if (distance == minDistance) {
					System.out.println("Clonar lista?");

				} else if (minDistance == 0) {
					System.out.println("Ruta completa");
					rutas.add(p);
				} else {
					System.out.println("Ruta abortada con: "
							+ adjacent.toString() + " con distancia "
							+ distance + " y min distancia " + minDistance);
					p = null;
				}

				break;
			case 1:
				adjacent = getPointDown(a);
				distance = getDistance(adjacent, b);

				if (p == null) {
					p = new ArrayList<Point>();
					p.add(a);
				}

				if (distance < minDistance) {
					p.add(adjacent);
					System.out.print("down: " + adjacent.toString() + " -> "
							+ distance + System.getProperty("line.separator"));
					BestWay3(adjacent, b, distance, p);
				} else if (distance == minDistance) {
					System.out.println("Clonar lista?");
				} else if (minDistance == 0) {
					System.out.println("Ruta completa");
					rutas.add(p);
				} else {
					System.out.println("Ruta abortada con: "
							+ adjacent.toString() + " con distancia "
							+ distance + " y min distancia " + minDistance);
					p = null;
				}

				break;

			case 2:
				adjacent = getPointLeft(a);
				distance = getDistance(adjacent, b);

				if (p == null) {
					p = new ArrayList<Point>();
					p.add(a);
				}

				if (distance <= minDistance) {
					p.add(adjacent);
					System.out.print("Left: " + adjacent.toString() + " -> "
							+ distance + System.getProperty("line.separator"));
					BestWay3(adjacent, b, distance, p);
				} else if (distance == minDistance) {
					System.out.println("Clonar lista?");
				} else if (minDistance == 0) {
					System.out.println("Ruta completa");
					rutas.add(p);
				} else {
					System.out.println("Ruta abortada con: "
							+ adjacent.toString() + " con distancia "
							+ distance + " y min distancia " + minDistance);
					p = null;
				}

				break;

			case 3:
				adjacent = getPointRight(a);
				distance = getDistance(adjacent, b);

				if (p == null) {
					p = new ArrayList<Point>();
					p.add(a);
				}

				if (distance < minDistance) {
					p.add(adjacent);
					System.out.print("Right: " + adjacent.toString() + " -> "
							+ distance + System.getProperty("line.separator"));
					BestWay3(adjacent, b, distance, p);
				} else if (distance == minDistance) {
					System.out.println("Clonar lista?");
				} else if (minDistance == 0) {
					// System.out.println("Ruta completa");
					rutas.add(p);
				} else {
					System.out.println("Ruta abortada con: "
							+ adjacent.toString() + " con distancia "
							+ distance + " y min distancia " + minDistance);
					p = null;
				}

				break;

			default:
				break;
			}

		}
	}
	
	private static void BestWay2(Point a, Point b, int minDistance) 
	{
		int distance = 0;
		
		Point adjacent = null;
				
			for (int i = 0; i < 4; i ++) {
				
				switch (i) {
				case 0:
					adjacent = getPointUp(a);
					distance = getDistance(adjacent, b);
					
					if(distance <= minDistance) {
						System.out.print("up: " + adjacent.toString() + " -> " + distance + System.getProperty("line.separator"));
						BestWay2(adjacent, b, distance);
					} else if(minDistance == 0) {
						System.out.println("Ruta completa");
					} else {
						System.out.println("Ruta abortada con: " + adjacent.toString() + " con distancia " + distance + " y min distancia " + minDistance);
					}
					break;
				case 1:
					adjacent = getPointDown(a);
					distance = getDistance(adjacent, b);					
					//System.out.print("down: " + adjacent.toString() + " -> " + distance + System.getProperty("line.separator"));
					if(distance < minDistance) {
						BestWay2(adjacent, b, distance);
					}	
					break;
					
				case 2:
					adjacent = getPointLeft(a);
					distance = getDistance(adjacent, b);
					//System.out.print("right: " + adjacent.toString() + " -> " + distance + System.getProperty("line.separator"));
					if(distance < minDistance) {
						BestWay2(adjacent, b, distance);
					}	
					break;
					
				case 3:
					adjacent = getPointRight(a);
					distance = getDistance(adjacent, b);
					//System.out.print("left: " + adjacent.toString() + " -> " + distance + System.getProperty("line.separator"));
					if(distance < minDistance) {
						BestWay2(adjacent, b, distance);
					}	
					break;
	
				default:
					break;
				}	
				
		}
	}
		
	
		
	private static void BestWay(Point a, Point b, int distance) 
	{
		
		Point adjacent = null;
				
			for (int i = 0; i < 4; i ++) {
				
				switch (i) {
				case 0:
					adjacent = getPointUp(a);
					distance = getDistance(a, b);
					
					break;
				case 1:
					adjacent = getPointDown(a);
					distance = getDistance(a, b);
					
					break;
					
				case 2:
					adjacent = getPointLeft(a);
					distance = getDistance(a, b);
					
					break;
					
				case 3:
					adjacent = getPointRight(a);
					distance = getDistance(a, b);
					
					break;
	
				default:
					break;
				}	
					
				
				if(distance != 0) {
					List<Point> p = new ArrayList<Point>();
					//p.add(a);
					p.addAll(getBetterPoint(adjacent, b, distance, null));
					rutas.add(p);
				}
		}
	}
		
	private static List<Point> getBetterPoint(Point a, Point b, int distance, List<Point> points) {
		
		if(points == null) {
			points = new ArrayList<Point>();
		}
		
		
		if(getDistance(a, b) <= distance) {
			points.add(a);
			distance = getDistance(a, b);
			firstBestWay(a, b, distance, points);
		}
		
		return points;
	}
		
	private static void firstBestWay(Point a, Point b, int distance, List<Point> lista) 
	{
		
		Point adjacent = null;
		List<Point> ruta = lista;	
		
		ruta.add(a);
		
		if(distance != 0) {
			for (int i = 0; i < 4; i ++) {
				
				switch (i) {
				case 0:
					adjacent = getPointUp(a);
					
					break;
				case 1:
					adjacent = getPointDown(a);
					break;
					
				case 2:
					adjacent = getPointLeft(a);
					break;
					
				case 3:
					adjacent = getPointRight(a);
					break;
	
				default:
					break;
				}	
				
				if(getDistance(adjacent, b) < distance) {
					distance = getDistance(adjacent, b);
					firstBestWay(adjacent, b, distance, ruta);
				}
			}		
		}
	}
		
	private static int getDistance(Point p1, Point p2) {
		//http://stackoverflow.com/questions/25935659/calculate-distance-between-two-points-java
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}
	
	private static Point getPointUp(Point p) {
		return new Point(p.x, p.y + 1);
	}
	
	private static Point getPointDown(Point p) {
		return new Point(p.x, p.y - 1);
	}
	
	private static Point getPointRight(Point p) {
		return new Point(p.x + 1, p.y);
	}
	
	private static Point getPointLeft(Point p) {
		return new Point(p.x - 1, p.y);
	}
	
	
	
	
}

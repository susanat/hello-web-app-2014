import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class prueba_points {

	public static void main(String[] args) {
    
		Point p1 = new Point(0,0);
		Point p2 = new Point(1,3);
		
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
		
		
		//En teoría pilla el primer camino que encuentra
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
		
		BestWay4(p1, p2, getDistance(p1, p2), null);
		
				
				for(List<Point> lst : rutas) {
					System.out.println("***************" + System.getProperty("line.separator"));
					for(Point p : lst) {
						System.out.println(p.toString());
					}			
					System.out.println("***************" + System.getProperty("line.separator"));
				}
				
		
		
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
					//clonamos el listado y lo añadimos al listado de listados
									
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
		
	private static List<List<Point>> rutas = new ArrayList<List<Point>>();
		
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

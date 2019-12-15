package capacityType;

import java.io.Serializable;

public enum CapacityType implements Serializable{
	Physical {
		private final String name = "Physical";
        
		public String toString() {
            return name;
        }
	},
	
	Special {
		private final String name = "Special";
        
		public String toString() {
            return name;
        }
	},
	
	Statut {
		private final String name = "Statut";
        
		public String toString() {
            return name;
        }
	};
	
	private CapacityType() {
	}
	
}

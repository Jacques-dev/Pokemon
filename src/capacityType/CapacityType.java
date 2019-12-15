package capacityType;

import java.io.Serializable;

public enum CapacityType implements Serializable{
	Physical {
        public String toString() {
            return "Physical";
        }
	},
	
	Special {
        public String toString() {
            return "Special";
        }
	},
	
	Statut {
        public String toString() {
            return "Statut";
        }
	};
	
	private CapacityType() {
	}
	
}
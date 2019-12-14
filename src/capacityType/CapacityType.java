package capacityType;

public enum CapacityType {
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

package ma.enset;

public class AvionImpl implements Avion {
    private State state;

    public AvionImpl() {
        state = new EnPisteState(this);
    }

    @Override
    public void sortirDuGarrage() {
        state.sortirDuGarrage();
    }

    @Override
    public void entrerAuGarrage() {
        state.entrerAuGarrage();
    }

    @Override
    public void decoller() {
        state.decoller();
    }

    @Override
    public void atterir() {
        state.atterir();
    }

    @Override
    public void doActivity() {
        state.doActivity();
    }


    abstract class State {
        protected AvionImpl avion;

        public State(AvionImpl avion) {
            this.avion = avion;
        }

        public abstract void sortirDuGarrage();

        public abstract void entrerAuGarrage();

        public abstract void decoller();

        public abstract void atterir();

        public abstract void doActivity();
    }

    class EnPisteState extends State {
        public EnPisteState(AvionImpl avion) {
            super(avion);
        }

        @Override
        public void sortirDuGarrage() {
            System.out.println("Impossible de sortir du garage depuis la piste");
        }

        @Override
        public void entrerAuGarrage() {
            System.out.println("transition: en pist -> au garage");
            avion.state = new AuGarageState(avion);
        }

        @Override
        public void decoller() {
            System.out.println("transition: en pist -> décoller");
            avion.state = new EnAirState(avion);
        }

        @Override
        public void atterir() {
            System.out.println("impossible d'atterir depuis la piste");
        }

        @Override
        public void doActivity() {
            for (int i = 0; i < 10; i++) {
                System.out.println("activité: en piste...");
            }
        }
    }

    class AuGarageState extends State {

        public AuGarageState(AvionImpl avion) {
            super(avion);
        }

        @Override
        public void sortirDuGarrage() {
            System.out.printf("Transition: au garage -> en piste");
            avion.state = new EnPisteState(avion);
        }

        @Override
        public void entrerAuGarrage() {
            System.out.println("je suis déjà au garage");
        }

        @Override
        public void decoller() {
            System.out.println("impossible de décoller depuis le garage");
        }

        @Override
        public void atterir() {
            System.out.println("impossible d'atterir depuis le garage");
        }

        @Override
        public void doActivity() {
            for (int i = 0; i < 10; i++) {
                System.out.println("activité: au garage...");
            }
        }
    }

    class EnAirState extends State {
        public EnAirState(AvionImpl avion) {
            super(avion);
        }

        @Override
        public void sortirDuGarrage() {
            System.out.println("impossible de sortir du garage depuis l'air");
        }

        @Override
        public void entrerAuGarrage() {
            System.out.println("impossible d'entrer au garage depuis l'air");
        }

        @Override
        public void decoller() {
            System.out.println("impossible de décoller je suis déjà en l'air");
        }

        @Override
        public void atterir() {
            System.out.println("transition: en air -> piste");
            avion.state = new EnPisteState(avion);
        }

        @Override
        public void doActivity() {
            for (int i = 0; i < 10; i++) {
                System.out.println("activité: en air...");
            }
        }
    }
}

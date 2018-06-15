package physic;

import base.GameObject;
import base.GameObjectManager;

import java.util.Arrays;
import java.util.List;

public class RunHitObject<B extends GameObject & PhysicBody> {

    private List<Class<B>> list; // Class<B>[]

    public RunHitObject(Class<B>... classes) { // Class<B>[] classes
        this.list = Arrays.asList(classes);
    }

    public <A extends GameObject & PhysicBody> void run(A object) {
        this.list
                .stream()
                .map(cls -> GameObjectManager.instance.checkCollision(object.getBoxCollider(), cls))
                .filter(gameObject -> gameObject != null)
                .forEach(gameObject -> {
                    gameObject.getHit(object);
                    object.getHit(gameObject);
                });
    }
}

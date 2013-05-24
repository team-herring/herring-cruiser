package org.herring.cruiser.server.service.receive.navigation;

import org.herring.cruiser.container.navigation.Navigation;
import org.herring.cruiser.container.navigation.NavigationManager;
import org.herring.cruiser.server.service.receive.CruiserService;
import org.herring.cruiser.server.request.next.Next;
import org.herring.cruiser.server.request.Request;

/**
 * Description.
 *
 * @author Youngdeok Kim
 * @since 1.0
 */
public class RegistNavigation implements CruiserService {

    @Override
    public void service(Request request, Next next) {
        Navigation navigation = new Navigation();
        navigation.setIP();

        NavigationManager.regist("test", navigation);

    }
}

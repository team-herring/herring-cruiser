package org.herring.cruiser.service;

import org.herring.cruiser.navigation.Navigation;
import org.herring.cruiser.navigation.NavigationManager;
import org.herring.cruiser.service.next.Next;
import org.herring.cruiser.service.request.Request;

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

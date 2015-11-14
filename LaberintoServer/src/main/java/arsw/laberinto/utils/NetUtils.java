package arsw.laberinto.utils;

import java.net.ConnectException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 *
 * @author hcadavid
 */
public class NetUtils {

    public static String getIPAddress() throws ConnectException {
        String result = null;
        Enumeration<NetworkInterface> interfaces = null;
        boolean addressFound = false;
        try {
            interfaces = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            throw new ConnectException("Unable to get network interfaces.");
        }

        if (interfaces != null) {
            while (interfaces.hasMoreElements() && !addressFound) {
                NetworkInterface i = interfaces.nextElement();
                Enumeration<InetAddress> addresses = i.getInetAddresses();
                while (addresses.hasMoreElements() && (result == null || result.isEmpty())) {
                    InetAddress address = addresses.nextElement();
                    if (!address.isLoopbackAddress()
                            && address.isSiteLocalAddress()) {
                        result = address.getHostAddress();
                        addressFound = true;
                    }
                }
            }
        }
        return result;
    }
}

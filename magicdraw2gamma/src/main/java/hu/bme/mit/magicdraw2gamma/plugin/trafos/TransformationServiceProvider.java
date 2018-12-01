package hu.bme.mit.magicdraw2gamma.plugin.trafos;

public class TransformationServiceProvider {
	
	private MagicdrawToGammaTransformer md2gTransformer;
	private InterfaceTransformer interfaceTransformer;
	private static TransformationServiceProvider instance = new TransformationServiceProvider();
	
	public static TransformationServiceProvider getInstance() {
		return instance;
	}
	
	public void registerMDTOGammaTransformer(MagicdrawToGammaTransformer md2gTransformer) {
		this.md2gTransformer = md2gTransformer;
	}
	
	public void registerInterfaceTransformer(InterfaceTransformer interfaceTransformer) {
		this.interfaceTransformer = interfaceTransformer;
	}
	
	public MagicdrawToGammaTransformer getStatechartTransformer() {
		return md2gTransformer;
	}
	
	public InterfaceTransformer getInterfaceTransformer() {
		return interfaceTransformer;
	}
	
	public void disposeAll() {
		md2gTransformer.dispose();
		interfaceTransformer.dispose();
	}
}

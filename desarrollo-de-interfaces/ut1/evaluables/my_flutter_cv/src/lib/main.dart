import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'My Flutter CV',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          seedColor: Colors.deepPurple,
          primaryContainer: Color(0xFF01C9AD),
          secondaryContainer: Color(0xFFFDBE11),
          primary: Color(0xFFF75B2B),
          surface: Color(0xFFF2EEE9),
        ),
        textTheme: TextTheme(
          displayLarge: const TextStyle(
            fontSize: 72,
            fontWeight: FontWeight.w900,
            letterSpacing: -5,
          ),
          titleLarge: const TextStyle(
            fontSize: 20,
            fontWeight: FontWeight.w900,
          ),
          titleSmall: TextStyle(fontSize: 16, fontWeight: FontWeight.w900),
          labelLarge: TextStyle(
            fontSize: 24,
            fontWeight: FontWeight.w900,
            letterSpacing: -0.5,
          ),
          bodySmall: TextStyle(
            letterSpacing: -0.5,
            fontSize: 14,
            fontWeight: FontWeight.bold,
          ),
        ),
      ),
      home: Scaffold(body: Body()),
    );
  }
}

class Body extends StatelessWidget {
  const Body({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.all(40),
      color: Theme.of(context).colorScheme.surface,
      child: Center(
        child: SingleChildScrollView(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [LeftColumn(), RightColumn()],
          ),
        ),
      ),
    );
  }
}

/// Subtitulo: el elemento común de ambas columnas
class Subtitle extends StatelessWidget {
  final Icon icon;
  final String text;
  final bool isHeaderSubtitle;

  const Subtitle(
    this.text, {
    super.key,
    this.icon = const Icon(Icons.mic, size: 24),
    this.isHeaderSubtitle = false,
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 320,
      decoration: BoxDecoration(
        color: Colors.white,
        border: BoxBorder.all(color: Colors.black),
        borderRadius: BorderRadius.all(Radius.circular(20)),
      ),
      child: Padding(
        padding: isHeaderSubtitle
            ? EdgeInsetsGeometry.fromLTRB(0, 0, 10, 0)
            : const EdgeInsets.fromLTRB(3, 3, 10, 3),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            Container(
              padding: isHeaderSubtitle
                  ? EdgeInsets.fromLTRB(5, 0, 0, 0)
                  : EdgeInsets.all(0),
              decoration: BoxDecoration(
                color: isHeaderSubtitle
                    ? Theme.of(context).colorScheme.primaryContainer
                    : Theme.of(context).colorScheme.secondaryContainer,
                border: isHeaderSubtitle
                    ? BoxBorder.fromLTRB(right: BorderSide())
                    : Border.all(),
                borderRadius: isHeaderSubtitle
                    ? BorderRadius.only(
                        topLeft: Radius.circular(30),
                        bottomLeft: Radius.circular(30),
                      )
                    : BorderRadius.circular(30),
              ),
              child: icon,
            ),
            SizedBox(width: 25),
            Text(text, style: Theme.of(context).textTheme.titleLarge),
          ],
        ),
      ),
    );
  }
}

/// Circulo: detallito incluido tanto en el Header como en
/// el elemento Card del contacto
class Circle extends StatelessWidget {
  final double size;
  final Color color;

  const Circle(this.size, this.color, {super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        border: Border.all(),
        borderRadius: BorderRadius.all(Radius.circular(50)),
        color: color,
      ),
      width: size,
      height: size,
    );
  }
}

/// Elementos de la columna izquierda

/// Elemento "Experiencia": para añadir en las secciones de experiencias laborales
/// y educación previa
class ExperienceItem extends StatelessWidget {
  final String title;
  final String subtitle;
  final String description;

  const ExperienceItem(
    this.title,
    this.subtitle,
    this.description, {
    super.key,
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      margin: EdgeInsets.fromLTRB(0, 15, 0, 15),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        spacing: 7,
        children: [
          Text(title, style: Theme.of(context).textTheme.titleSmall),
          Text(
            subtitle,
            style: Theme.of(context).textTheme.labelLarge?.copyWith(
              color: Theme.of(context).colorScheme.primary,
            ),
          ),
          Text(
            description,
            style: Theme.of(context).textTheme.bodySmall,
            textAlign: TextAlign.justify,
          ),
        ],
      ),
    );
  }
}

/// Elemento que se añade en la sección de habilidades personales, que
/// representa con un slider estático y sin interacción el nivel que tiene
/// la persona con dicha habilidad.
class SkillItem extends StatelessWidget {
  final String title;
  final double value;

  const SkillItem(this.title, this.value, {super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 80,
      margin: EdgeInsets.all(15),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Text(
            title,
            textAlign: TextAlign.left,
            style: Theme.of(context).textTheme.bodySmall,
          ),
          SliderTheme(
            data: SliderTheme.of(context).copyWith(
              disabledActiveTrackColor: Theme.of(context).colorScheme.primary,
              disabledInactiveTrackColor: Theme.of(
                context,
              ).colorScheme.secondaryContainer,
              thumbShape: SliderComponentShape.noThumb,
              overlayShape: SliderComponentShape.noOverlay,
              trackHeight: 16,
            ),
            child: Slider(value: value, onChanged: null, min: 0.0, max: 1.0),
          ),
        ],
      ),
    );
  }
}

/// Estructura de la columna de la izquierda, haciendo usos de variables para
/// segmentar el código.
class LeftColumn extends StatelessWidget {
  const LeftColumn({super.key});

  @override
  Widget build(BuildContext context) {
    final semaphore = Padding(
      padding: const EdgeInsets.fromLTRB(0, 10, 10, 0),
      child: Column(
        spacing: 5,
        children: [
          Circle(20, Colors.redAccent),
          Circle(20, const Color.fromARGB(255, 216, 216, 36)),
          Circle(20, const Color.fromARGB(255, 38, 92, 40)),
        ],
      ),
    );

    final header = Container(
      padding: EdgeInsets.fromLTRB(0, 0, 0, 50),
      margin: EdgeInsets.fromLTRB(0, 0, 0, 25),
      decoration: BoxDecoration(
        border: BoxBorder.fromLTRB(
          bottom: BorderSide(color: Colors.black, width: 2),
        ),
      ),
      child: Row(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          semaphore,
          Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text(
                "MARIANA\nNAPOLITANI",
                style: Theme.of(context).textTheme.displayLarge,
              ),
              SizedBox(height: 30),
              Subtitle(
                "DIGITAL MARKETING",
                icon: Icon(Icons.search_rounded, color: Colors.black, size: 32),
                isHeaderSubtitle: true,
              ),
            ],
          ),
        ],
      ),
    );

    final workExperienceSection = Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Subtitle("WORK EXPERIENCE"),
        SizedBox(height: 8),
        ExperienceItem(
          "Digital Marketer Intern | Thynk Unlimited",
          "2012 – 2013",
          """Assisted the marketing team on the SEO project
of the Rimberio Co. website, which has
successfully increased the traffic by 15% or 90
new customers per month.""",
        ),
        ExperienceItem(
          "Digital Marketing Manager | Liceria & Co.",
          "2013 – PRESENT",
          """Designed, implemented, and optimized the new
promotion campaign for Salford & Co. that
increased sales from the social media platform
by 300%.""",
        ),
      ],
    );

    final educationSection = Column(
      crossAxisAlignment: CrossAxisAlignment.start,
      children: [
        Subtitle("EDUCATION"),
        ExperienceItem(
          "Bachelor of Science in Marketing",
          "May 2007 - August 2011",
          "\t\t• University of Muhammad Patel\n\t\t• GPA: 3.90",
        ),
      ],
    );

    final skillsSection = Column(
      children: [
        Subtitle("PERSONAL SKILLS"),
        Row(
          children: [
            SkillItem("SEO", 0.8),
            SkillItem("Leadership", 0.45),
            SkillItem("Copywriting", 0.7),
          ],
        ),
      ],
    );

    return Column(
      spacing: 10,
      children: [
        header,
        workExperienceSection,
        educationSection,
        skillsSection,
      ],
    );
  }
}

/// Elementos de la columna derecha
///
/// Un "item" de la seccion Contacto, que incluye el contacto en si mismo como texto,
/// asi como tambien de detalle un Switch no interactuable cuyo estilo fue cambiado
/// con el uso de un SwitchTheme para que estuviese acorde a la referencia de Canva.
class ContactItem extends StatelessWidget {
  final String title;
  final bool switchOn;
  final bool inMiddle;

  const ContactItem(
    this.title, {
    super.key,
    this.switchOn = false,
    this.inMiddle = false,
  });

  @override
  Widget build(BuildContext context) {
    final BoxBorder? border = inMiddle
        ? BoxBorder.fromLTRB(
            bottom: BorderSide(width: 2),
            top: BorderSide(width: 2),
          )
        : null;
    return Container(
      padding: EdgeInsets.fromLTRB(0, 10, 0, 10),
      decoration: BoxDecoration(border: border),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceBetween,
        children: [
          Text(title, style: Theme.of(context).textTheme.bodySmall),
          SwitchTheme(
            data: SwitchThemeData(
              thumbColor: WidgetStateColor.resolveWith((
                Set<WidgetState> states,
              ) {
                return Theme.of(context).colorScheme.primaryContainer;
              }),
              thumbIcon: WidgetStateProperty.resolveWith((
                Set<WidgetState> states,
              ) {
                return const Icon(Icons.circle_outlined, color: Colors.black);
              }),
              trackColor: WidgetStateColor.resolveWith((
                Set<WidgetState> states,
              ) {
                return Theme.of(context).colorScheme.secondaryContainer;
              }),
              trackOutlineColor: WidgetStateColor.resolveWith((
                Set<WidgetState> states,
              ) {
                return Colors.black;
              }),
              trackOutlineWidth: WidgetStateProperty.resolveWith((
                Set<WidgetState> states,
              ) {
                return 2.0;
              }),
            ),
            child: Switch(value: switchOn, onChanged: null),
          ),
        ],
      ),
    );
  }
}

/// Estructura de la columna derecha, haciendo uso de variables para almacenar las secciones
/// y mantener el codigo mejor segmentado. Hace uso de la clase Stack, que sirve para apilar
/// otros Widget y darles esos niveles de profundidad.
class RightColumn extends StatelessWidget {
  const RightColumn({super.key});

  @override
  Widget build(BuildContext context) {
    final personPicture = Container(
      width: 275,
      height: 400,
      decoration: BoxDecoration(
        color: Color(0xFFAB2733),
        border: Border.all(width: 2),
        borderRadius: BorderRadius.only(
          topLeft: Radius.circular(20),
          topRight: Radius.circular(20),
          bottomRight: Radius.circular(20),
        ),
      ),
      child: Image.asset("images/girl.png", fit: BoxFit.cover),
    );

    final aboutSection = Container(
      width: 290,
      margin: EdgeInsets.fromLTRB(0, 40, 0, 0),
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.start,
        children: [
          Subtitle("ABOUT ME"),
          SizedBox(height: 20),
          Text(
            "I have been working in the digital marketing industry for more than nine subtitle. I have many experiences working individually and as a team member. My principle in working is exposure because the core of digital marketing is all about how to increase the exposure of the promoted product. I am also a hard worker, strategic and result-driven person. I always keep the clients as the priority, so many of them feel comfortable working with me.",
            textAlign: TextAlign.justify,
            style: Theme.of(context).textTheme.bodySmall,
          ),
        ],
      ),
    );

    final whiteCircle = Circle(10, Colors.white);
    final contactSection = Container(
      alignment: Alignment.topLeft,
      child: Container(
        decoration: BoxDecoration(
          border: Border.all(width: 2),
          borderRadius: BorderRadius.circular(5),
          color: Theme.of(context).colorScheme.surface,
        ),
        child: Column(
          children: [
            Container(
              height: 32,
              width: 310,
              padding: EdgeInsets.fromLTRB(0, 0, 10, 0),
              decoration: BoxDecoration(
                color: Theme.of(context).colorScheme.primary,
                border: BoxBorder.fromLTRB(bottom: BorderSide(width: 2)),
                borderRadius: BorderRadius.only(
                  topLeft: Radius.circular(5),
                  topRight: Radius.circular(5),
                ),
              ),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.end,
                spacing: 2,
                children: [whiteCircle, whiteCircle, whiteCircle],
              ),
            ),
            SizedBox(
              width: 235,
              child: Column(
                children: [
                  ContactItem("+123-456-7890"),
                  ContactItem(
                    "hello@reallygreatsite.com",
                    switchOn: true,
                    inMiddle: true,
                  ),
                  ContactItem("123 Anywhere St., Any city"),
                ],
              ),
            ),
          ],
        ),
      ),
    );

    return Stack(
      children: [
        Positioned(
          left: 100,
          top: -200,
          child: Container(
            width: 300,
            height: 350,
            decoration: BoxDecoration(
              color: Theme.of(context).colorScheme.secondaryContainer,
              border: Border.all(width: 2),
              borderRadius: BorderRadius.circular(15),
            ),
          ),
        ),

        Positioned(
          top: 240,
          child: Container(
            height: 550,
            width: 400,
            decoration: BoxDecoration(
              color: Theme.of(context).colorScheme.primaryContainer,
              border: Border.all(width: 2),
              borderRadius: BorderRadius.circular(15),
            ),
          ),
        ),

        Container(
          padding: EdgeInsets.fromLTRB(25, 0, 25, 0),
          child: Column(
            children: [
              SizedBox(height: 50),
              personPicture,
              aboutSection,
              SizedBox(height: 100),
              contactSection,
            ],
          ),
        ),

        Positioned(
          left: 285,
          top: 35,
          child: Icon(Icons.auto_awesome, size: 80),
        ),
      ],
    );
  }
}
